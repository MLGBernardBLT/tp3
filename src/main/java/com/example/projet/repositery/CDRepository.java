package com.example.projet.repositery;

import com.example.projet.model.document.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CDRepository extends JpaRepository<CD, Long> {
    @Query(value = "SELECT d FROM Document d LEFT JOIN FETCH d.bibliotheque b WHERE d.id = :cdId")
    Optional<CD> findByIdWithBibliotheque(@Param("cdId") long cdId);
}
