package com.example.projet.repositery;

import com.example.projet.model.fonctionnalites.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepositery extends JpaRepository<Emprunt, Long > {
}
