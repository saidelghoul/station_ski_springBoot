package com.example.station.Controllers;

import com.example.station.entities.Abonnement;
import com.example.station.entities.Cour;
import com.example.station.services.CourInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cour")
@RequiredArgsConstructor
public class CoursController {

    private final CourInterface courInterface;
    @PostMapping
    public Cour addCour(@RequestBody Cour c) {return courInterface.addCour(c);}
    @PutMapping
    public Cour updateCour(@RequestBody Cour c)
    {
        return courInterface.updateCour(c);
    }
    @GetMapping
    public List<Cour> getAll()
    {
        return courInterface.getAll();
    }
    @GetMapping("{id}")
    public Cour getId(@PathVariable long id) {return courInterface.getId(id);}

    @GetMapping("{nameMon}")
    public List<Cour> GetCoursByMoniteurSql(String nameMon) {
        return courInterface.GetCoursByMoniteurSql(nameMon);
    }
}