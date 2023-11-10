package com.example.station.services;

import com.example.station.entities.Cour;
import com.example.station.repositeries.CourRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourService implements CourInterface {

         private final CourRepo courRepo;
    @Override
    public Cour addCour(Cour c)
    {
        return courRepo.save(c);
    }

    @Override
    public Cour updateCour(Cour c)
    {
        return courRepo.save(c);
    }

    @Override
    public List<Cour> getAll()
    {
        return courRepo.findAll();
    }

    @Override
    public Cour getId(long id) {return courRepo.findById(id).orElse(null);
        //return courRepo.findById(id).orElseThrow() -> new IllegalArgumentException("no cours");
        }

    @Override
    public void  deletId(long id) {courRepo.deleteById(id);}

    @Override
    public List<Cour> GetCoursByMoniteurSql(String nameMon) {
        return courRepo.GetCoursByMoniteurSql(nameMon);
    }
}


