package com.example.projet.controllers;

import com.example.projet.service.BibliothequeService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    private BibliothequeService bibliothequeService;

    public RootController(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    @GetMapping("/")
    public String getRootRequest(Model model){
        model.addAttribute("pageTitle", "Index");
        model.addAttribute("h1Text", "Première page");
        return "index";
    }
}
