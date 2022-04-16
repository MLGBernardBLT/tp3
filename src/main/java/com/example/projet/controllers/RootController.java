package com.example.projet.controllers;

import com.example.projet.service.BibliothequeService;
import com.example.projet.service.UtilisateurService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    private final UtilisateurService utilisateurService;

    private final BibliothequeService bibliothequeService;

    public RootController(BibliothequeService bibliothequeService,
                          UtilisateurService utilisateurService) {
        this.bibliothequeService = bibliothequeService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public String getRootRequest(Model model){
        model.addAttribute("pageTitle", "Index");
        model.addAttribute("h1Text", "Bibliotheque");
        return "index";
    }

    @GetMapping("/emprunteurs")
    public String getEmprunteurs(Model model) {
        model.addAttribute("h1Title", "Les emprunteurs :");
        var emprunteurs = utilisateurService.findAllEmprunteurs();
        model.addAttribute("emprunteurs", emprunteurs);
        return "emprunteurs";
    }
}
