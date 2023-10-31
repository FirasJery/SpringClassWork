package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.services.ISkieurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skieurs")
public class SkieurContoller {
    private final ISkieurService skieurService;

    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @GetMapping
    public List<Skieur> findAll() {
        return skieurService.findAll();
    }

    @GetMapping("{id}")
    public Skieur findById(@PathVariable int id) {
        return skieurService.FindOneById(id);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        skieurService.deleteOneById(id);
        return true;
    }

    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skieurService.updateSkieur(skieur);
    }

}
