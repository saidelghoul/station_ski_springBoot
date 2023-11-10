package com.example.station.services;

import com.example.station.entities.Abonnement;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.repositeries.AbonnementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AbonnementService implements AbonnementInterface {

    private final AbonnementRepo abonnementRepo;

    @Override
    public Abonnement addAbonnement(Abonnement a) {
        return abonnementRepo.save(a) ;
    }

    @Override
    public Abonnement updateAbonnement(Abonnement a) {
        return abonnementRepo.save(a);
    }

    @Override
    public List<Abonnement> getAll() {
        return abonnementRepo.findAll();
    }

    @Override
    public Abonnement getId(long id) {
        return abonnementRepo.findById(id).get();
    }

    @Override
    public void deletId(long id) {abonnementRepo.deleteById(id);}

    @Override
    public Set<Abonnement> findByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement) {
        return abonnementRepo.findByTypeAbonnementOrderByDateDebut(typeAbonnement);
    }

    @Override
    public List<Abonnement> findByDateDebutAfterAndDateFinBefore(LocalDate dateDebut, LocalDate dateFin) {
        return abonnementRepo.findByDateDebutAfterAndDateFinBefore(dateDebut,dateFin);
    }
}
