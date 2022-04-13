package com.example.projet.repositery;


import com.example.projet.model.document.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepositery extends JpaRepository<DVD, Long> {
}
