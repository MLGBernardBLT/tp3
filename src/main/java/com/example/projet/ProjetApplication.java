package com.example.projet;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.document.Document;
import com.example.projet.service.BibliothequeService;
import com.example.projet.service.DocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.Properties;

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

    }
}
