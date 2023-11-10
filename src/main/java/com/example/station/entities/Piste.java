package com.example.station.entities;

import com.example.station.entities.enums.Couleur;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)

public class Piste {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY )
    @Setter(AccessLevel.NONE)
    Long id;
    String nompist;
    Integer longueure;
    Integer pente;

    @Enumerated (EnumType.STRING)
    Couleur couleur;

    @ManyToMany(mappedBy = "pistes")
    Set<Skieur> skieurs;


}
