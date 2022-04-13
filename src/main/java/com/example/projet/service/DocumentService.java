package com.example.projet.service;

import com.example.projet.repositery.DocumentRepositery;
import org.springframework.stereotype.Component;


@Component
public class DocumentService {
    private final DocumentRepositery documentRepositery;

    public DocumentService(DocumentRepositery documentRepositery) {
        this.documentRepositery = documentRepositery;
    }

}
