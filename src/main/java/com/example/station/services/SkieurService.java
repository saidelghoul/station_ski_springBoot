package com.example.station.services;

import com.example.station.entities.Cour;
import com.example.station.entities.Inscrption;
import com.example.station.entities.Piste;
import com.example.station.entities.Skieur;
import com.example.station.entities.enums.Couleur;
import com.example.station.entities.enums.Support;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.entities.enums.TypeCours;
import com.example.station.repositeries.AbonnementRepo;
import com.example.station.repositeries.CourRepo;
import com.example.station.repositeries.PisteRepo;
import com.example.station.repositeries.SkieurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkieurService implements SkieurInterface {

    private final SkieurRepo skieurRepo;
    private final PisteRepo  pisteRepo;
    private final CourRepo courRepo;
    private final AbonnementRepo abonnementRepo;
    @Override
    public Skieur addSkieur(Skieur s) {
        return skieurRepo.save(s);
    }

    @Override
    public Skieur updateSkieur(Skieur s) {
        return skieurRepo.save(s);
    }

    @Override
    public List<Skieur> getAll() {
        return skieurRepo.findAll();
    }

    @Override
    public Skieur getId(long id) {
        return skieurRepo.findById(id).get();
    }

    @Override
    public void deletId(long id) {skieurRepo.deleteById(id);}

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepo.findById(numSkieur).orElse(null);
        Piste piste=pisteRepo.findById(numPiste).orElse(null);
        //skieur.setPistes(piste);
        skieur.getPistes().add(piste);
        return  skieur;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {
        Cour cour=courRepo.findById(numCourse).orElse(null);
        //skier.set(inscri);
        return null;
    }

    @Override
    public List<Skieur> findByAbonnement_TypeAbonnement(TypeAbonnement abonnement_typeAbonnement) {

        return skieurRepo.findByAbonnement_TypeAbonnement(abonnement_typeAbonnement);
    }

    @Override
    public List<Skieur> findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours) {
        return skieurRepo.findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(abonnement_typeAbonnement,pistes_couleur,inscriptions_cours_support,inscriptions_cours_typeCours);
    }
}
