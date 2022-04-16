package com.example.projet.repositery;


import com.example.projet.model.fonctionnalites.RetourEmprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetourEmpruntRepositery extends JpaRepository<RetourEmprunt, Long> {
}
