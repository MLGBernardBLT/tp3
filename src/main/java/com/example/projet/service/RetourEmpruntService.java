package com.example.projet.service;

import com.example.projet.model.document.Document;
import com.example.projet.model.fonctionnalites.Emprunt;
import com.example.projet.model.fonctionnalites.RetourEmprunt;
import com.example.projet.repositery.DocumentRepositery;
import com.example.projet.repositery.RetourEmpruntRepositery;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Component
public class RetourEmpruntService {
    private final RetourEmpruntRepositery retourEmpruntRepositery;
    private final DocumentRepositery documentRepositery;

    public RetourEmpruntService(RetourEmpruntRepositery retourEmpruntRepositery,
                                DocumentRepositery documentRepositery) {
        this.retourEmpruntRepositery = retourEmpruntRepositery;
        this.documentRepositery = documentRepositery;
    }

    public RetourEmprunt createRetour(Optional<Emprunt> emprunt, LocalDateTime date_Retour) {
        if (emprunt.isEmpty()) {
            return null;
        }
        List<Document> documentsEmpruntes = emprunt.get().getDocuments();
        for (Document document : documentsEmpruntes) {
            document.exemplaireRetourner();
            documentRepositery.save(document);
        }
        return retourEmpruntRepositery.save(new RetourEmprunt(emprunt.get(), date_Retour));
    }
}
