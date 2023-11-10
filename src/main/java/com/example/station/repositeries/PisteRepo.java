package com.example.station.repositeries;

import com.example.station.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PisteRepo extends JpaRepository<Piste,Long> {
}
