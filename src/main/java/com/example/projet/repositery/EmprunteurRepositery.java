package com.example.projet.repositery;

import com.example.projet.model.utilisateur.Emprunteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprunteurRepositery extends JpaRepository<Emprunteur, Long> {
}
