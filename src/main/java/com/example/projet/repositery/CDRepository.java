package com.example.projet.repositery;

import com.example.projet.model.document.CD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD, Long> {
}
