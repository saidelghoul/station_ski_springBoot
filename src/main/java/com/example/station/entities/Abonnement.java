package com.example.station.entities;

import com.example.station.entities.enums.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor //constructor non parametres
@AllArgsConstructor // constructeur parametres
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Setter(AccessLevel.NONE)
    Long id;

    Long numAbon;
    LocalDate dateDebut;
    LocalDate dateFin;
    Float prixAbon;
    @Enumerated (EnumType.STRING)
    TypeAbonnement typeAbonnement;

    @OneToOne
    Skieur skieurs;


}
