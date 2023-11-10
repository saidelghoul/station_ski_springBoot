package com.example.station.Controllers;

import com.example.station.entities.Moniteur;
import com.example.station.services.MoniteurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monitor")
@RequiredArgsConstructor
public class MoniteurController {


    private final MoniteurInterface moniteurInterface;

    @PostMapping
    public Moniteur addAbonnement(@RequestBody Moniteur m) {return moniteurInterface.addMoniteur(m) ;}

    @PutMapping
    public Moniteur updateAbonnement(@RequestBody Moniteur m) {return moniteurInterface.updateMoniteur(m);}

    @GetMapping
    public List<Moniteur> getAll() {return moniteurInterface.getAll();}

    @GetMapping("{id}")
    public Moniteur getId(@PathVariable long id) {return moniteurInterface.getId(id);}

    @DeleteMapping
    public void deletId(@PathVariable long id) {moniteurInterface.deletId(id);}

    @PostMapping("/addInstructorAndAssignToCourse/{numCourse}")
    Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable  Long numCourse){
        return moniteurInterface.addInstructorAndAssignToCourse(moniteur,numCourse);
    }


}
