package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Moniteur;
import tn.esprit.firaseljary.repositories.CoursRepository;
import tn.esprit.firaseljary.repositories.MoniteurRepository;
import tn.esprit.firaseljary.services.IMoniteurService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {
    private final IMoniteurService moniteurService ;

    @PostMapping("/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable int numCourse) // to test
    {
        return this.moniteurService.addInstructorAndAssignToCourse(moniteur,numCourse) ;
    }
}
