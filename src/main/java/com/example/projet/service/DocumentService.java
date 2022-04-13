package com.example.projet.service;

import com.example.projet.model.document.Livre;
import com.example.projet.repositery.LivreRepositery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DocumentService {
    private final LivreRepositery livreRepositery;

    public DocumentService(LivreRepositery livreRepositery) {
        this.livreRepositery = livreRepositery;
    }

    public Livre saveLivre(String nom, String auteur, String editeur, LocalDate dateParution, String genre, int nbrePage) {
        return livreRepositery.save(new Livre(nom, auteur, editeur, dateParution, genre, nbrePage));
    }
    
}
