package com.example.projet.service;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.document.Document;
import com.example.projet.repositery.*;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Component
public class BibliothequeService {

    private final BibliothequeRepositery bibliothequeRepositery;
    private final LivreRepositery livreRepositery;
    private final CDRepository cdRepositery;
    private DVDRepositery dvdRepositery;
    private DocumentRepositery documentRepositery;

    public BibliothequeService(BibliothequeRepositery bibliothequeRepositery,
                                LivreRepositery livreRepositery,
                                CDRepository cdRepositery,
                                DVDRepositery dvdRepositery,
                                DocumentRepositery documentRepositery) {
        this.bibliothequeRepositery = bibliothequeRepositery;
        this.livreRepositery = livreRepositery;
        this.cdRepositery = cdRepositery;
        this.dvdRepositery = dvdRepositery;
        this.documentRepositery = documentRepositery;
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

    public void addCDToBibliotheque(long cdId, long bibliothequeId) {
        var cdOpt = cdRepositery.findByIdWithBibliotheque(cdId);
        var bibliothequeOpt = bibliothequeRepositery.findById(bibliothequeId);

        if(cdOpt.isEmpty() || bibliothequeOpt.isEmpty()){
            return;
        }
        var cd = cdOpt.get();
        var bibliotheque = bibliothequeOpt.get();

        cd.setBibliotheque(bibliotheque);
        bibliotheque.setDocuments(bibliotheque.getDocuments());
        cdRepositery.save(cd);
        bibliothequeRepositery.save(bibliotheque);
    }

    public void addDVDToBibliotheque(long dvdId, long bibliothequeId) {
        var dvdOpt = dvdRepositery.findByIdWithBibliotheque(dvdId);
        var bibliothequeOpt = bibliothequeRepositery.findById(bibliothequeId);

        if(dvdOpt.isEmpty() || bibliothequeOpt.isEmpty()){
            return;
        }
        var dvd = dvdOpt.get();
        var bibliotheque = bibliothequeOpt.get();

        dvd.setBibliotheque(bibliotheque);
        bibliotheque.setDocuments(bibliotheque.getDocuments());
        dvdRepositery.save(dvd);
        bibliothequeRepositery.save(bibliotheque);
    }

    @Transactional
    public List<Document> findByNomDocuments(String nom) {
        Optional<List<Document>> documentsOpt = documentRepositery.findByNomDocuments(nom);
        if(documentsOpt.isEmpty() || documentsOpt.get().isEmpty()){
            throw new IllegalArgumentException("aucun document avec ce nom dans la base de données");
        }
        return documentsOpt.get();
    }

    public List<Document> findByAuteurDocuments(String auteur) {
        Optional<List<Document>> documentsOpt = documentRepositery.findByAuteurDocuments(auteur);
        if(documentsOpt.isEmpty() || documentsOpt.get().isEmpty()){
            throw new IllegalArgumentException("aucun document avec cet auteur dans la base de données");
        }
        return documentsOpt.get();
    }

    public List<Document> findByDateParutionDocuments(LocalDate dateParution) {
        Optional<List<Document>> documentsOpt = documentRepositery.findByDateParutionDocuments(dateParution);
        if(documentsOpt.isEmpty() || documentsOpt.get().isEmpty()){
            throw new IllegalArgumentException("aucun document avec cet auteur dans la base de données");
        }
        return documentsOpt.get();
    }
}
