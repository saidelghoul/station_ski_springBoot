package com.example.station.repositeries;

import com.example.station.entities.Inscrption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepo extends JpaRepository<Inscrption,Long> {
}
