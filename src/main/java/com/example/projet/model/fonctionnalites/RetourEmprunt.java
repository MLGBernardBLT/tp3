package com.example.projet.model.fonctionnalites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class RetourEmprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "retour_id")
    private long id;

    @OneToOne(mappedBy = "retour")
    private Emprunt emprunts;

    private LocalDateTime dateRetour;

    public RetourEmprunt(Emprunt emprunts, LocalDateTime dateRetour) {
        this.emprunts = emprunts;
        this.dateRetour = dateRetour;
    }
}
