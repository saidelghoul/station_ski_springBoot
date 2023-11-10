package com.example.station.services;

import com.example.station.entities.Cour;
import com.example.station.entities.Moniteur;
import com.example.station.repositeries.CourRepo;
import com.example.station.repositeries.MoniteurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MoniteurService implements MoniteurInterface {


    private final MoniteurRepo moniteurRepo;
    private final CourRepo courRepo;
    @Override
    public Moniteur addMoniteur(Moniteur m) {
        return moniteurRepo.save(m);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur m) {
        return moniteurRepo.save(m);
    }

    @Override
    public List<Moniteur> getAll() {
        return moniteurRepo.findAll();
    }

    @Override
    public Moniteur getId(long id) {

        return moniteurRepo.findById(id).orElse(null);
               // .orElseThrow(() -> new IllegalArgumentException("No Monitor found with this Id " +id));
    }

    @Override
    public void deletId(long id) {moniteurRepo.deleteById(id);}

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cour cours = courRepo.findById(numCourse).orElse(null);
        Set<Cour> coursSet = moniteur.getCours();
        coursSet.add(cours);
        moniteur.setCours(coursSet);
        return moniteurRepo.save(moniteur);
    }
}
