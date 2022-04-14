package com.example.projet;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.Emprunt;
import com.example.projet.model.document.CD;
import com.example.projet.model.document.DVD;
import com.example.projet.model.document.Document;
import com.example.projet.model.document.Livre;
import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.model.utilisateur.Utilisateur;
import com.example.projet.service.BibliothequeService;
import com.example.projet.service.DocumentService;
import com.example.projet.service.EmpruntService;
import com.example.projet.service.UtilisateurService;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {


    private final BibliothequeService bibliothequeService;
    private DocumentService documentService;
    private UtilisateurService utilisateurService;
    private EmpruntService empruntService;

    public ProjetApplication(BibliothequeService bibliothequeService,
                             DocumentService documentService,
                             UtilisateurService utilisateurService,
                             EmpruntService empruntService) {
        this.bibliothequeService = bibliothequeService;
        this.documentService = documentService;
        this.utilisateurService = utilisateurService;
        this.empruntService = empruntService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // même si on n'a qu'une seule bibliotheque, je veux tout de même
        // avoir une bibliotheque dans ma base de données qui est
        // JavaTown.
        final Bibliotheque bibliotheque = bibliothequeService.saveBibliotheque("JavaTown");
//        System.out.println(bibliotheque);

        final Livre livre = documentService.saveLivre("red Eyes Sword", "Takahiro", "Kurokawa",
                LocalDate.of(2010, 8, 21), "roman", 235, 1);
//        System.out.println(livre);
        final CD cd = documentService.saveCD("Rise of the red Monarch", "AmaLee", "Leegion Creative",
                LocalDate.of(2022, 9, 21), "album", 1);
//        System.out.println(cd);
        final DVD dvd = documentService.saveDVD("Pokemon the Movie : Mewtwo Strike Back !",
                "Kunihiko Yuyama", "Choji Yoshikawa", LocalDate.of(1998, 7, 18),
                "film", 1);
//        System.out.println(dvd);
        final Emprunteur emprunteur = utilisateurService.saveEmprunteur("Thomas Laforest", "Bernard");


        bibliothequeService.saveBibliotheque(bibliotheque);
//        System.out.println(bibliotheque);

        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());
        System.out.println(livre.getBibliotheque());
        System.out.println(bibliotheque.getDocuments());
        bibliothequeService.addCDToBibliotheque(cd.getId(), bibliotheque.getId());
        bibliothequeService.addDVDToBibliotheque(dvd.getId(), bibliotheque.getId());
        bibliothequeService.addEmprunteurToBibliotheque(emprunteur.getId(), bibliotheque.getId());

        List<Document> rechercheDocumentsNom1 = bibliothequeService.findByNomDocuments("Pokemon");
//        for (Document document : rechercheDocumentsNom1){
//            System.out.println(document);
//        }
        List<Document> rechercheDocumentsNom2 = bibliothequeService.findByNomDocuments("red");
//        for (Document document : rechercheDocumentsNom2){
//            System.out.println(document);
//        }

        List<Document> rechercheDocumentAuteur1 = bibliothequeService.findByAuteurDocuments("Takahiro");
//        System.out.println(rechercheDocumentAuteur1);
        List<Document> rechercheDocumentAuteur2 = bibliothequeService.findByAuteurDocuments("AmaLee");
//        System.out.println(rechercheDocumentAuteur2);
        List<Document> rechercheDocumentAuteur3 = bibliothequeService.findByAuteurDocuments("Kunihiko Yuyama");
//        System.out.println(rechercheDocumentAuteur3);

        List<Document> rechercheDocumentDateParution1 = bibliothequeService
                .findByDateParutionDocuments(LocalDate.of(2010, 8, 21));
//        System.out.println(rechercheDocumentDateParution1);
        List<Document> rechercheDocumentDateParution2 = bibliothequeService
                .findByDateParutionDocuments(LocalDate.of(2022, 9, 21));
//        System.out.println(rechercheDocumentDateParution2);
        List<Document> rechercheDocumentDateParution3 = bibliothequeService
                .findByDateParutionDocuments(LocalDate.of(1998, 7, 18));
//        System.out.println(rechercheDocumentDateParution3);

        List<Document> rechercheDocumentGenre1 = bibliothequeService.findByGenreDocuments("roman");
//        System.out.println(rechercheDocumentGenre1);
        List<Document> rechercheDocumentGenre2 = bibliothequeService.findByGenreDocuments("film");
//        System.out.println(rechercheDocumentGenre2);
        List<Document> rechercheDocumentGenre3 = bibliothequeService.findByGenreDocuments("album");
//        System.out.println(rechercheDocumentGenre3);

        final Emprunt emprunt1 = empruntService.saveEmprunt(emprunteur, rechercheDocumentAuteur1, LocalDateTime.now(),
                                                            LocalDateTime.now().plusDays(21));
    }
}
