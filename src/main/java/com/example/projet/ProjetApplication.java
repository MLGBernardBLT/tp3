package com.example.projet;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.document.CD;
import com.example.projet.model.document.DVD;
import com.example.projet.model.document.Document;
import com.example.projet.model.document.Livre;
import com.example.projet.service.BibliothequeService;
import com.example.projet.service.DocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {


    private final BibliothequeService bibliothequeService;
    private DocumentService documentService;

    public ProjetApplication(BibliothequeService bibliothequeService,
                             DocumentService documentService) {
        this.bibliothequeService = bibliothequeService;
        this.documentService = documentService;
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

        final Livre livre = documentService.saveLivre("red Eyes Sword", "Takahiro", "Kurokawa", LocalDate.of(2010, 8, 21), "roman", 235);
//        System.out.println(livre);
        final CD cd = documentService.saveCD("Rise of the red Monarch", "AmaLee", "Leegion Creative", LocalDate.of(2022, 9, 21), "album");
//        System.out.println(cd);
        final DVD dvd = documentService.saveDVD("Pokemon the Movie : Mewtwo Strike Back !", "Kunihiko Yuyama", "Choji Yoshikawa", LocalDate.of(1998, 7, 18), "film");
//        System.out.println(dvd);


        bibliotheque.getDocuments().add(livre);
        bibliotheque.getDocuments().add(cd);
        bibliotheque.getDocuments().add(dvd);

        bibliothequeService.saveBibliotheque(bibliotheque);
//        System.out.println(bibliotheque);

        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());
        bibliothequeService.addCDToBibliotheque(cd.getId(), bibliotheque.getId());
        bibliothequeService.addDVDToBibliotheque(dvd.getId(), bibliotheque.getId());

        List<Document> documents = bibliothequeService.findByNomDocuments("Pokemon");
//        for (Document document : documents){
//            System.out.println(document);
//        }
        List<Document> documents2 = bibliothequeService.findByNomDocuments("red");
//        for (Document document : documents2){
//            System.out.println(document);
//        }

        List<Document> documents3 = bibliothequeService.findByAuteurDocuments("Takahiro");
        System.out.println(documents3);
        List<Document> documents4 = bibliothequeService.findByAuteurDocuments("AmaLee");
        System.out.println(documents4);
        List<Document> documents5 = bibliothequeService.findByAuteurDocuments("Kunihiko Yuyama");
        System.out.println(documents5);
    }
}
