package com.example.projet.service;

import com.example.projet.model.fonctionnalites.Emprunt;
import com.example.projet.model.document.Document;
import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.repositery.DocumentRepositery;
import com.example.projet.repositery.EmpruntRepositery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class EmpruntService {
    private EmpruntRepositery empruntRepositery;
    private DocumentRepositery documentRepositery;

    public EmpruntService(EmpruntRepositery emprunteurRepositery,
                          DocumentRepositery documentRepositery) {
        this.empruntRepositery = emprunteurRepositery;
        this.documentRepositery = documentRepositery;
    }

    @Transactional
    public Optional<Emprunt> createEmprunt(Emprunteur emprunteur, List<Document> documentsEmpruntes,
                                           LocalDateTime debut, LocalDateTime fin) {
        final Emprunt emprunt = new Emprunt(emprunteur, documentsEmpruntes, debut, fin);
        for (Document document : documentsEmpruntes) {
            if (!empruntPossible(document)) {
                return Optional.empty();
            }
            document.exemplaireEmprunter();
            documentRepositery.save(document);
        }
        return Optional.of(empruntRepositery.save(emprunt));
    }

    private boolean empruntPossible(Document document) {
        return document.getExemplaires() > 0;
    }
}
