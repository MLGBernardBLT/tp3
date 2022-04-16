package com.example.projet.model.fonctionnalites;

import com.example.projet.model.document.Document;
import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.model.utilisateur.Utilisateur;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emprunt_id")
    private long id;

    @ManyToMany
    private List<Document> documents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    @ToString.Exclude
    private Utilisateur emprunteur = new Emprunteur();

    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRemiseMax;

    public Emprunt(Utilisateur emprunteur, List<Document> documents,
                   LocalDateTime dateEmprunt, LocalDateTime dateRemiseMax) {
        this.emprunteur = emprunteur;
        this.documents = documents;
        this.dateEmprunt = dateEmprunt;
        this.dateRemiseMax = dateRemiseMax;
    }
}
