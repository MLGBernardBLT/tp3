package com.example.projet.service;

import com.example.projet.model.Bibliotheque;
import com.example.projet.repositery.BibliothequeRepositery;
import com.example.projet.repositery.LivreRepositery;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class BibliothequeService {

    private BibliothequeRepositery bibliothequeRepositery;
    private LivreRepositery livreRepositery;

    public BibliothequeService(BibliothequeRepositery bibliothequeRepositery,
                                LivreRepositery livreRepositery) {
        this.bibliothequeRepositery = bibliothequeRepositery;
        this.livreRepositery = livreRepositery;
    }

    public Bibliotheque saveBibliotheque(String nomBiblio) {
        return bibliothequeRepositery.save(new Bibliotheque(nomBiblio));
    }

    public Bibliotheque saveBibliotheque(Bibliotheque bibliotheque) {
        return bibliothequeRepositery.save(bibliotheque);
    }

    public void addLivreToBibliotheque(long livreId, long bibliothequeId) {
        var livreOpt = livreRepositery.findByIdWithBibliotheque(livreId);
        var bibliothequeOpt = bibliothequeRepositery.findById(bibliothequeId);

        if(livreOpt.isEmpty() || bibliothequeOpt.isEmpty()){
            return;
        }
        var livre = livreOpt.get();
        var bibliotheque = bibliothequeOpt.get();

        livre.setBibliotheque(bibliotheque);
        bibliotheque.setDocuments(bibliotheque.getDocuments());
        livreRepositery.save(livre);
        bibliothequeRepositery.save(bibliotheque);
    }
}
