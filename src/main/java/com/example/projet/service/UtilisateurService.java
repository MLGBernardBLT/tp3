package com.example.projet.service;

import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.repositery.EmprunteurRepositery;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurService {
    private final EmprunteurRepositery emprunteurRepositery;

    public UtilisateurService(EmprunteurRepositery emprunteurRepositery){
        this.emprunteurRepositery = emprunteurRepositery;
    }

    public Emprunteur createEmprunteur(String nom, String prenom) {
        return emprunteurRepositery.save(new Emprunteur(nom, prenom));
    }
}
