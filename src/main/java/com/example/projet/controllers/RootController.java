package com.example.projet.controllers;

import com.example.projet.dto.EmprunteurForm;
import com.example.projet.model.utilisateur.Emprunteur;
import com.example.projet.service.BibliothequeService;
import com.example.projet.service.UtilisateurService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    private UtilisateurService utilisateurService;

    private BibliothequeService bibliothequeService;

    public RootController(BibliothequeService bibliothequeService,
                          UtilisateurService utilisateurService) {
        this.bibliothequeService = bibliothequeService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
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

    @GetMapping("/emprunteurcreate")
    public String getEmprunteurCreate(@ModelAttribute EmprunteurForm emprunteurForm, BindingResult result, Model model) {
        model.addAttribute("emprunteurForm", emprunteurForm);
        return "/emprunteuredit";
    }

    @PostMapping("/emprunteurcreate")
    public String emprunteurPost(@Valid @ModelAttribute EmprunteurForm emprunteurForm,
                                 BindingResult errors,
                                 RedirectAttributes redirectAttributes) {

        logger.info("emprunteur : " + emprunteurForm);
        //retourne tout le temps les champs null...
        if (errors.hasErrors()) {
            return "/emprunteuredit";
        }
        final Emprunteur emprunteur = utilisateurService.createEmprunteur(emprunteurForm.toEmprunteur());
        emprunteurForm.setId(Long.toString(emprunteur.getId()));

        redirectAttributes.addFlashAttribute("emprunteurForm", emprunteurForm);
        redirectAttributes.addAttribute("id", emprunteurForm.getId());

        return "redirect:/emprunteuredit/{id}";
    }


}
