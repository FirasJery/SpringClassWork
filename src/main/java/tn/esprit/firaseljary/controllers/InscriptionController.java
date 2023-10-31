package tn.esprit.firaseljary.controllers;


import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.services.IinscriptionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("inscription")
public class InscriptionController {

    private final IinscriptionService iinscriptionService;

    @PostMapping("/assignins/{numSkieur}")
    public Inscription addInsAndAssignToSkieur(@RequestBody Inscription inscription,@PathVariable int numSkieur) {

        return iinscriptionService.addInscriptionAndAssignSkieur(inscription, numSkieur);
    }
    @PostMapping("AssignRtoC/{numRegistration}/{numCourse}")
    public Inscription assignRegistrationToCourse(@PathVariable int numRegistration,@PathVariable int numCourse) {

        return iinscriptionService.assignRegistrationToCourse(numRegistration, numCourse);
    }
}

