package com.example.projet.service;

import com.example.projet.model.document.Document;
import com.example.projet.model.fonctionnalites.Emprunt;
import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.repositery.DocumentRepositery;
import com.example.projet.repositery.EmpruntRepositery;
import com.example.projet.repositery.EmprunteurRepositery;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Component
public class UtilisateurService {
    private final EmprunteurRepositery emprunteurRepositery;
    private DocumentRepositery documentRepositery;
    private EmpruntRepositery empruntRepositery;

    public UtilisateurService(EmprunteurRepositery emprunteurRepositery,
                              DocumentRepositery documentRepositery,
                              EmpruntRepositery empruntRepositery){
        this.emprunteurRepositery = emprunteurRepositery;
        this.documentRepositery = documentRepositery;
        this.empruntRepositery = empruntRepositery;
    }

    public Emprunteur createEmprunteur(String nom, String prenom) {
        return emprunteurRepositery.save(new Emprunteur(nom, prenom));
    }

    public Optional<List<Emprunt>> getEmpruntsByEmprunteur(long emprunteurId) {
        Optional<List<Emprunt>> empruntsOpt = empruntRepositery.getEmpruntsByEmprunteur(emprunteurId);
        if(empruntsOpt.isEmpty() || empruntsOpt.get().isEmpty()){
            return Optional.empty();
        }
        return empruntsOpt;
    }

    public Optional<List<Document>> getDocumentsByEmprunteur(long emprunteurId) {
        Optional<List<Document>> documentsOpt = documentRepositery.getDocumentsByEmprunteur(emprunteurId);
        if(documentsOpt.isEmpty() || documentsOpt.get().isEmpty()){
            return Optional.empty();
        }
        return documentsOpt;
    }

}
