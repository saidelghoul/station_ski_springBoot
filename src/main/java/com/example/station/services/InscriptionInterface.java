package com.example.station.services;

import com.example.station.entities.Inscrption;

import java.util.List;

public interface InscriptionInterface {


    Inscrption addInscription(Inscrption i);
    Inscrption updateInscription(Inscrption i);
    List<Inscrption> getAll();
    Inscrption getId(long id);
    void deletId(long id);

    Inscrption addRegistrationAndAssignToSkier(long idSk, Inscrption inscrption);


    Inscrption assignRegistrationToCourse(Long numIns, Long numCour);


}
