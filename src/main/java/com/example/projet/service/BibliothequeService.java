package com.example.projet.service;

import com.example.projet.model.Bibliotheque;
import com.example.projet.repositery.BibliothequeRepositery;
import com.example.projet.repositery.CDRepository;
import com.example.projet.repositery.DVDRepositery;
import com.example.projet.repositery.LivreRepositery;
import org.springframework.stereotype.Component;


@Component
public class BibliothequeService {

    private final BibliothequeRepositery bibliothequeRepositery;
    private final LivreRepositery livreRepositery;
    private final CDRepository cdRepositery;
    private DVDRepositery dvdRepositery;

    public BibliothequeService(BibliothequeRepositery bibliothequeRepositery,
                                LivreRepositery livreRepositery,
                                CDRepository cdRepositery,
                                DVDRepositery dvdRepositery) {
        this.bibliothequeRepositery = bibliothequeRepositery;
        this.livreRepositery = livreRepositery;
        this.cdRepositery = cdRepositery;
        this.dvdRepositery = dvdRepositery;
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
}
