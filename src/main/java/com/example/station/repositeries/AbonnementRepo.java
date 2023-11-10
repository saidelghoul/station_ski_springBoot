package com.example.station.repositeries;

import com.example.station.entities.Abonnement;
import com.example.station.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepo extends JpaRepository<Abonnement,Long> {

    Set<Abonnement>findByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement);  //name atribute dans abonnement class *t*ypeAbonnement firt case majuscule
    List<Abonnement> findByDateDebutAfterAndDateFinBefore(LocalDate dateDebut, LocalDate dateFin);
}

