package com.example.projet.repositery;

import com.example.projet.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepositery extends JpaRepository<Document, Long> {
}
