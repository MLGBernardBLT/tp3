package com.example.projet.repositery;


import com.example.projet.model.document.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DVDRepositery extends JpaRepository<DVD, Long> {
    @Query(value = "SELECT d FROM Document d LEFT JOIN d.bibliotheque b WHERE d.id = :dvdId")
    Optional<DVD> findByIdWithBibliotheque(@Param("dvdId") long dvdId);
}
