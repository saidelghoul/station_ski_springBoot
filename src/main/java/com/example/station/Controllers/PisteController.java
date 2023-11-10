package com.example.station.Controllers;

import com.example.station.entities.Piste;
import com.example.station.services.PisteInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("piste")
@RequiredArgsConstructor
public class PisteController {

    private final PisteInterface pisteInterface;

    @PostMapping
    public Piste addAbonnement(@RequestBody Piste p) {return pisteInterface.addPiste(p) ;}

    @PutMapping
    public Piste updateAbonnement(@RequestBody Piste p) {return pisteInterface.updatePiste(p);}

    @GetMapping
    public List<Piste> getAll() {return pisteInterface.getAll();}

    @GetMapping("{id}")
    public Piste getId(@PathVariable long id) {return pisteInterface.getId(id);}

    @DeleteMapping
    public void deletId(@PathVariable long id) {pisteInterface.deletId(id);}


}
