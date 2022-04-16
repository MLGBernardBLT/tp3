package com.example.projet.repositery;

import com.example.projet.model.fonctionnalites.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmpruntRepositery extends JpaRepository<Emprunt, Long > {
    @Query(value = "SELECT e FROM Emprunt e LEFT JOIN FETCH e.emprunteur ee WHERE ee.id =:emprunteurId")
    Optional<List<Emprunt>> getEmpruntsByEmprunteur(@Param("emprunteurId") long emprunteurId);
}
