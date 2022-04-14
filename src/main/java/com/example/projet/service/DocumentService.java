package com.example.projet.service;

import com.example.projet.model.document.CD;
import com.example.projet.model.document.DVD;
import com.example.projet.model.document.Livre;
import com.example.projet.repositery.CDRepository;
import com.example.projet.repositery.DVDRepositery;
import com.example.projet.repositery.LivreRepositery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DocumentService {
    private final LivreRepositery livreRepositery;
    private final CDRepository cdRepositery;
    private final DVDRepositery dvdRepositery;

    public DocumentService(LivreRepositery livreRepositery, CDRepository cdRepositery, DVDRepositery dvdRepositery) {
        this.livreRepositery = livreRepositery;
        this.cdRepositery = cdRepositery;
        this.dvdRepositery = dvdRepositery;
    }

    public Livre saveLivre(String nom, String auteur, String editeur,
                           LocalDate dateParution, String genre,
                           int nbrePage, int exemplaires) {
        return livreRepositery.save(new Livre(nom, auteur, editeur, dateParution, genre, nbrePage, exemplaires));
    }

    public Livre saveLivre(Livre livre){
        return livreRepositery.save(livre);
    }

    public CD saveCD(String nom, String auteur, String editeur,
                     LocalDate dateParution,
                     String genre, int exemplaires) {
        return cdRepositery.save(new CD(nom, auteur, editeur, dateParution, genre, exemplaires));
    }

    public CD saveCD(CD cd){
        return cdRepositery.save(cd);
    }

    public DVD saveDVD(String nom, String regiseur, String editeur,
                       LocalDate dateParution,
                       String genre, int exemplaires) {
        return dvdRepositery.save(new DVD(nom, regiseur, editeur, dateParution, genre, exemplaires));
    }

    public DVD saveDVD(DVD dvd){
        return dvdRepositery.save(dvd);
    }
}
