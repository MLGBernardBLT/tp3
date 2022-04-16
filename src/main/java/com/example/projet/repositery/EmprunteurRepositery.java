package com.example.projet.repositery;

import com.example.projet.model.document.Document;
import com.example.projet.model.utilisateur.Emprunteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmprunteurRepositery extends JpaRepository<Emprunteur, Long> {
    @Query(value = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.bibliotheque WHERE u.id = :emprunteurId")
    Optional<Emprunteur> findByIdWithBibliotheque(@Param("emprunteurId") long emprunteurId);

    @Query(value = "SELECT u FROM Utilisateur u WHERE u.id = :emprunteurId")
    Emprunteur findEmprunteurById(@Param("emprunteurId") long emprunteurId);
}
