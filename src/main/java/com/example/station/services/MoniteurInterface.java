package com.example.station.services;

import com.example.station.entities.Moniteur;

import java.util.List;


public interface MoniteurInterface {


    Moniteur addMoniteur(Moniteur m);
    Moniteur updateMoniteur(Moniteur m );
    List<Moniteur> getAll();
    Moniteur getId(long id);
    void deletId(long id);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
