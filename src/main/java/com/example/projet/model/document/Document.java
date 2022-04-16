package com.example.projet.model.document;

import com.example.projet.model.Bibliotheque;
import com.example.projet.model.fonctionnalites.Emprunt;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "document_type")
@SuperBuilder
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private long id;
    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate anneePublication;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "bibliotheque_id")
    @ToString.Exclude
    private Bibliotheque bibliotheque;

    @ManyToMany
    @JoinTable(
            name = "document_emprunt",
            joinColumns = @JoinColumn(name = "emprunt_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    @ToString.Exclude
    private List<Emprunt> emprunts = new ArrayList<>();
    private int exemplaires;

    public Document(String titre, String auteur, String editeur,
                    LocalDate anneePublication, String genre, int exemplaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePublication = anneePublication;
        this.genre = genre;
        this.exemplaires = exemplaires;
    }

    public void exemplaireRetourner(){
        exemplaires++;
    }

    public void exemplaireEmprunter() {
        exemplaires--;
    }
}
