package com.example.station.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class Inscrption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;

    Long numInsc;
    Integer numSem;
    @ManyToOne
    Skieur skieurs;
    @JsonIgnore
    @ManyToOne
    Cour cours;
}
