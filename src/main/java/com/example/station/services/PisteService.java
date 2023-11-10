package com.example.station.services;

import com.example.station.entities.Piste;
import com.example.station.repositeries.PisteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PisteService implements PisteInterface {

    private final PisteRepo pisteRepo;
    @Override
    public Piste addPiste(Piste p) {
        return pisteRepo.save(p);
    }

    @Override
    public Piste updatePiste(Piste p) {
        return pisteRepo.save(p);
    }

    @Override
    public List<Piste> getAll() {
        log.info("bonjour");
        return (List<Piste>) pisteRepo.findAll();
    }

    @Override
    public Piste getId(long id) {
        log.info("bonjour");
        return  pisteRepo.findById(id).get();
    }

    @Override
    public void deletId(long id) {pisteRepo.deleteById(id);}



}
