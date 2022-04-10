package com.example.projet.repositery;

import com.example.projet.model.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliothequeRepositery extends JpaRepository<Bibliotheque, Long> {
}
