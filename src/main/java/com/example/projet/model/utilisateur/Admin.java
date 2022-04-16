package com.example.projet.model.utilisateur;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("admin")
public class Admin extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private long id;

    public Admin(String nom, String prenom) {
        super(nom, prenom);
    }
}
