package com.example.station.services;

import com.example.station.entities.Abonnement;
import com.example.station.entities.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementInterface {

    Abonnement addAbonnement(Abonnement a);
    Abonnement updateAbonnement(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getId(long id);
    void deletId(long id);
    Set<Abonnement> findByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement);
    List<Abonnement> findByDateDebutAfterAndDateFinBefore(LocalDate dateDebut, LocalDate dateFin);




}
