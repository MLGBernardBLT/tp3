package com.example.projet.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("dvd")
@SuperBuilder
@ToString(callSuper = true)
public class DVD extends Document {
    public DVD(String titre, String auteur, String editeur, LocalDate anneePublication, String genre, int exemplaires) {
        super(titre, auteur, editeur, anneePublication, genre, exemplaires);
    }
}
