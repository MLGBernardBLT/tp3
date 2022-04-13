package com.example.projet.service;

import com.example.projet.model.Bibliotheque;
import com.example.projet.repositery.BibliothequeRepositery;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class BibliothequeService {

    private BibliothequeRepositery bibliothequeRepositery;

    public BibliothequeService(BibliothequeRepositery bibliothequeRepositery) {
        this.bibliothequeRepositery = bibliothequeRepositery;
    }

    public Bibliotheque saveBibliotheque(String nomBiblio) {
        return bibliothequeRepositery.save(new Bibliotheque(nomBiblio));
    }
}
