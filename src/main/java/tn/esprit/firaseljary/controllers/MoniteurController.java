package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Moniteur;
import tn.esprit.firaseljary.services.IMoniteurService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {
    private final IMoniteurService moniteurService ;
    @PostMapping
    public Moniteur addMonnteur(@RequestBody Moniteur moniteur)
    {
        return this.moniteurService.addInstructor(moniteur);
    }

    @PostMapping("/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable int numCourse)
    {
        return this.moniteurService.addInstructorAndAssignToCourse(moniteur,numCourse) ;
    }
}
