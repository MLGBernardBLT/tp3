package com.example.projet.repositery;

import com.example.projet.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LivreRepositery extends JpaRepository<Livre, Long> {

    @Query(value = "SELECT d FROM Document d LEFT JOIN FETCH d.bibliotheque b WHERE d.id = :livreId")
    Optional<Livre> findByIdWithBibliotheque(@Param("livreId") long livreId);
}
