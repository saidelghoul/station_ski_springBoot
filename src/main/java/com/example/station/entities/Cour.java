package com.example.station.entities;


import com.example.station.entities.enums.Support;
import com.example.station.entities.enums.TypeCours;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;

    Long numCour;
    Integer niveau;

    @Enumerated(EnumType.STRING)
    TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    Support support;

    Float prix;
    Integer creneau;
    @OneToMany(mappedBy = "cours")//cours est un variable presenter dans incription qui present la table cour
    Set<Inscrption> inscriptions;
}
