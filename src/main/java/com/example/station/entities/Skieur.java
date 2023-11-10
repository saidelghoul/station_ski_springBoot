package com.example.station.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long numSkieur;

    String nomS;
    String prenomS;
    LocalDate dateN;
    String ville;

    @ManyToMany()
    Set<Piste> pistes;

    @JsonIgnore ///////////
    @OneToMany(mappedBy = "skieurs") // relation géré par inscription (table)(relation bidirectionnelle)
    Set<Inscrption> inscriptions;

    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;
}
