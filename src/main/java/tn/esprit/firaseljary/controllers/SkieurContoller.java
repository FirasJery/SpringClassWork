package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
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


    ///////////////
    @PostMapping("assignSkierToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable int numSkieur,@PathVariable int numPiste)
    {
        return skieurService.assignSkierToPiste(numSkieur,numPiste);
    }

    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable int numCourse)
    {
        return this.skieurService.addSkierAndAssignToCourse(skieur , numCourse) ;
    }

    @GetMapping("retrieveSkiersBySubscriptionType/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement)
    {
        return this.skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
