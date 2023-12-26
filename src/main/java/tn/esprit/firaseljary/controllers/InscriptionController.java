package tn.esprit.firaseljary.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.enums.Support;
import tn.esprit.firaseljary.services.IinscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("inscription")
public class InscriptionController {

    private final IinscriptionService iinscriptionService;

    @PostMapping("/assignins/{numSkieur}")
    public Inscription addInsAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable int numSkieur) {

        return iinscriptionService.addInscriptionAndAssignSkieur(inscription, numSkieur);
    }

    @PostMapping("AssignRtoC/{numRegistration}/{numCourse}")
    public Inscription assignRegistrationToCourse(@PathVariable int numRegistration, @PathVariable int numCourse) {

        return iinscriptionService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("addRegistrationAndAssignToSkierAndCourse/{numSkieur}/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable int numSkieur, @PathVariable int numCours) {

        return iinscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
    }


    @GetMapping("/numWeeksCourseOfInstructorBySupport/{numInstructor}/{support}")
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        return this.iinscriptionService.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }


}

