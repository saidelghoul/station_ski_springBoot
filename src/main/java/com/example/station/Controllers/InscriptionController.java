package com.example.station.Controllers;

import com.example.station.entities.Inscrption;
import com.example.station.services.InscriptionInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscrption")
@RequiredArgsConstructor
public class InscriptionController {

    private final InscriptionInterface inscriInterface;

    @PostMapping
    public Inscrption addAbonnement(@RequestBody Inscrption i) {
        return inscriInterface.addInscription(i) ;
    }

    @PutMapping
    public Inscrption updateAbonnement(@RequestBody Inscrption i) { return inscriInterface.updateInscription(i);}

    @GetMapping
    public List<Inscrption> getAll() {return inscriInterface.getAll();}

    @GetMapping("{id}")
    public Inscrption getId(@PathVariable long id) {
        return inscriInterface.getId(id);
    }

    @DeleteMapping
    public void deletId(@PathVariable long id) {inscriInterface.deletId(id);}

    @PostMapping("{idSk}")

    public Inscrption addRegistrationAndAssignToSkier(@PathVariable long idSk , @RequestBody Inscrption inscrption){
        return inscriInterface.addRegistrationAndAssignToSkier(idSk,inscrption);

    }
    @PutMapping("{numIns}/{numCour}")
    Inscrption assignRegistrationToCourse(@PathVariable Long numIns, @PathVariable Long numCour){
        return inscriInterface.assignRegistrationToCourse(numIns,numCour);
    }
}
