package com.example.projet;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.document.Document;
import com.example.projet.model.document.Livre;
import com.example.projet.service.BibliothequeService;
import com.example.projet.service.DocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

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
        System.out.println(bibliotheque);

        final Livre livre = documentService.saveLivre("Red Eyes Sword", "Takahiro", "Kurokawa", LocalDate.of(2010, 8, 21), "roman", 235);
        System.out.println(livre);
    }
}
