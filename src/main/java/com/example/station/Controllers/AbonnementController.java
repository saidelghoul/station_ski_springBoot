package com.example.station.Controllers;

import com.example.station.entities.Abonnement;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.services.AbonnementInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("abonnement")
@RequiredArgsConstructor
public class AbonnementController {

    private final AbonnementInterface abonnementInterface;

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement a) {
        return abonnementInterface.addAbonnement(a);
    }

    @PutMapping
    public Abonnement updateAbonnement(@RequestBody Abonnement a) {
        return abonnementInterface.updateAbonnement(a);
    }

    @GetMapping
    public List<Abonnement> getAll() {
        return abonnementInterface.getAll();
    }

    @GetMapping("{id}")
    public Abonnement getId(@PathVariable long id) {
        return abonnementInterface.getId(id);
    }

    @DeleteMapping
    public void deletId(@PathVariable long id) {
        abonnementInterface.deletId(id);
    }

    @GetMapping("type/{typeAbonnement}")
    public Set<Abonnement> findByTypeAbonnementOrderByDateDebut(@RequestParam TypeAbonnement typeAbonnement) {
        return abonnementInterface.findByTypeAbonnementOrderByDateDebut(typeAbonnement);
    }

    @GetMapping("")
    public List<Abonnement> findByDateDebutAfterAndDateFinBefore(@RequestParam LocalDate dateDebut,  LocalDate dateFin) {
        return abonnementInterface.findByDateDebutAfterAndDateFinBefore(dateDebut, dateFin);
    }
}

