package com.example.station.services;

import com.example.station.entities.Cour;
import com.example.station.entities.Inscrption;
import com.example.station.entities.Skieur;
import com.example.station.repositeries.CourRepo;
import com.example.station.repositeries.InscriptionRepo;
import com.example.station.repositeries.SkieurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InscriptionService implements InscriptionInterface {

    private final InscriptionRepo inscriptionRepo;
    private final SkieurRepo skieurRepo;
    private final CourRepo courRepo;


    @Override
    public Inscrption addInscription(Inscrption i) {
        return inscriptionRepo.save(i);
    }

    @Override
    public Inscrption updateInscription(Inscrption i) {
        return inscriptionRepo.save(i);
    }

    @Override
    public List<Inscrption> getAll() {
        return inscriptionRepo.findAll();
    }

    @Override
    public Inscrption getId(long id) {
        return inscriptionRepo.findById(id).get();
    }

    @Override
    public void deletId(long id) {inscriptionRepo.deleteById(id);}

    @Override
    public Inscrption addRegistrationAndAssignToSkier(long idSk, Inscrption inscrption) {
        Skieur skieur=skieurRepo.findById(idSk).orElse(null);
        inscrption.setSkieurs(skieur);
        return inscriptionRepo.save(inscrption);
    }

    @Transactional
    @Override
    public Inscrption assignRegistrationToCourse(Long numIns, Long numCour) {
        Cour cour=courRepo.findById(numCour).orElse(null);//si objet existet get<liste>/id and add to liste if new object
        Inscrption inscrption=inscriptionRepo.findById(numIns).orElse(null);
        inscrption.setCours(cour);
        return inscrption;
    }


}
