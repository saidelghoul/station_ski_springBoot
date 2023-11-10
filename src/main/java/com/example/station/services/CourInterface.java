package com.example.station.services;

import com.example.station.entities.Cour;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourInterface {

    Cour addCour(Cour c);
    Cour updateCour(Cour C);
    List<Cour> getAll();
    Cour getId(long id);
    void deletId(long id);

    List<Cour>GetCoursByMoniteurSql(@Param("nameMon") String nameMon);


}
