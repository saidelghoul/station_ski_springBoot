package com.example.station.Controllers;

import com.example.station.entities.Piste;
import com.example.station.entities.Skieur;
import com.example.station.entities.enums.Couleur;
import com.example.station.entities.enums.Support;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.entities.enums.TypeCours;
import com.example.station.services.SkieurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skieur")
@RequiredArgsConstructor
public class SkieurController {

    private final SkieurInterface skieurInterface;

    @GetMapping
    public List<Skieur> getAll() {
        return skieurInterface.getAll();
    }
    @GetMapping("{id}")
    public Skieur getId(@PathVariable long id) {
        return skieurInterface.getId(id);
    }
    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur s) {
        return skieurInterface.updateSkieur(s);
    }
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur s) {
        return skieurInterface.addSkieur(s);
    }
    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur skier, @PathVariable Long numCourse) {
        return skieurInterface.addSkierAndAssignToCourse(skier,numCourse) ;
    }

    @PutMapping("addSkieurToPiste")
    public Skieur assignSkierToPiste(@RequestParam Long numSkieur, @RequestParam Long numPiste)
    {return skieurInterface.assignSkierToPiste(numSkieur,numPiste);}

    @GetMapping("typAbonnnement/{abonnement_typeAbonnement}")
    public List<Skieur> findByAbonnement_TypeAbonnement(@PathVariable TypeAbonnement abonnement_typeAbonnement) {
        return skieurInterface.findByAbonnement_TypeAbonnement(abonnement_typeAbonnement);
    }

    @GetMapping ("{abonnement_typeAbonnement}/{pistes_couleur}/{inscriptions_cours_support}/{inscriptions_cours_typeCours}")
    public List<Skieur> findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(@RequestParam TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours) {
        return skieurInterface.findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(abonnement_typeAbonnement,pistes_couleur,inscriptions_cours_support,inscriptions_cours_typeCours);
    }

}
