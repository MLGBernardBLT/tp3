package com.example.projet.repositery;

import com.example.projet.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepositery extends JpaRepository<Livre, Long> {
}
