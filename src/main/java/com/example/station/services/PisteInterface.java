package com.example.station.services;

import com.example.station.entities.Piste;

import java.util.List;

public interface PisteInterface {

    Piste addPiste(Piste p);
    Piste updatePiste(Piste p);
    List<Piste> getAll();
    Piste getId(long id);
    void deletId(long id);

}
