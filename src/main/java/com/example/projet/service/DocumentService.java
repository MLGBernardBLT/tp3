package com.example.projet.service;

import com.example.projet.model.document.Document;
import com.example.projet.model.document.Livre;
import com.example.projet.repositery.DocumentRepositery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DocumentService {
    private final DocumentRepositery documentRepositery;

    public DocumentService(DocumentRepositery documentRepositery) {
        this.documentRepositery = documentRepositery;
    }

}
