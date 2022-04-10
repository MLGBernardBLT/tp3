package com.example.projet.model.utilisateur;

import com.example.projet.model.Bibliotheque;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur")
@SuperBuilder
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "utilisateur_id")
    private long id;
    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "bibliotheque_id")
    private Bibliotheque bibliotheque;

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
