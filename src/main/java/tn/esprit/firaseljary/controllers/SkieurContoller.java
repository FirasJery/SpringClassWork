package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.services.ISkieurService;
import tn.esprit.firaseljary.services.SkieurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skieurs")
public class SkieurContoller {
    private final ISkieurService skieurService;
    @PostMapping("/add")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }
    @GetMapping
    public List<Skieur> findAll(){
        return skieurService.findAll();
    }

    @GetMapping("{id}")
    public Skieur findById(@PathVariable int id) {
        Skieur skieur = skieurService.FindOneById(id);
        return skieur;
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id){
        Skieur skieur = skieurService.FindOneById(id);
        skieurService.deleteOneById(id);
        return true;

    }
    @PutMapping
    public Skieur updateSkieur(@PathVariable int id,@RequestBody Skieur skieurd){
        skieurd.setAbonnement(skieurd.getAbonnement());
        skieurd.setNomS(skieurd.getNomS());
        skieurd.setVille(skieurd.getVille());
        skieurd.setPrenomS(skieurd.getPrenomS());
        skieurd.setSetInscription(skieurd.getSetInscription());
        skieurd.setDateNaissance(skieurd.getDateNaissance());
        skieurd.setSetPiste(skieurd.getSetPiste());
        skieurService.updateSkieur(skieurd);
        return skieurd;
    }

}
