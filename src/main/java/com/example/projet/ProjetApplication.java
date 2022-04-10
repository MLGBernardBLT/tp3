package com.example.projet;

import com.example.projet.model.Bibliotheque;
import com.example.projet.service.BibliothequeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {


    private final BibliothequeService bibliothequeService;

    public ProjetApplication(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Bibliotheque bibliotheque = bibliothequeService.saveBibliotheque("JavaTown");
        System.out.println(bibliotheque);
    }
}
