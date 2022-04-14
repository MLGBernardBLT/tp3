package com.example.projet.model;

import com.example.projet.model.document.Document;
import com.example.projet.model.utilisateur.Utilisateur;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bibliotheque_id")
    private long id;
    private String nom;

    @OneToMany(mappedBy = "bibliotheque")
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "bibliotheque")
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Bibliotheque(String nom) {
        this.nom = nom;
    }
}
