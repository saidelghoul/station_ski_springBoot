package com.example.station.services;


import com.example.station.entities.Piste;
import com.example.station.entities.Skieur;
import com.example.station.entities.enums.Couleur;
import com.example.station.entities.enums.Support;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.entities.enums.TypeCours;

import java.util.List;

public interface SkieurInterface {


    Skieur addSkieur(Skieur s);
    Skieur updateSkieur(Skieur s);
    List<Skieur> getAll();
    Skieur getId(long id);
    void deletId(long id);


    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
    List<Skieur> findByAbonnement_TypeAbonnement(TypeAbonnement abonnement_typeAbonnement);

    List<Skieur> findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours);


}
