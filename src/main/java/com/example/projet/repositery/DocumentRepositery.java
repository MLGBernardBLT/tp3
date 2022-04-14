package com.example.projet.repositery;

import com.example.projet.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DocumentRepositery extends JpaRepository<Document, Long> {
    @Query(value = "SELECT d FROM Document d LEFT JOIN FETCH d.bibliotheque b WHERE d.titre LIKE %:nomDocument%")
    Optional<List<Document>> findByNomDocuments(@Param("nomDocument") String nom);

    @Query(value = "SELECT d FROM Document d LEFT JOIN FETCH d.bibliotheque b WHERE d.auteur LIKE %:auteurDocument%")
    Optional<List<Document>> findByAuteurDocuments(@Param("auteurDocument") String auteur);
}
