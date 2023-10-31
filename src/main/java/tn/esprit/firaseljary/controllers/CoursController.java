package tn.esprit.firaseljary.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.services.ICoursService;

@RestController
@RequiredArgsConstructor
@RequestMapping("cours")
public class CoursController {

    private final ICoursService coursService ;
    @PostMapping
    public Cours addCours(@RequestBody Cours cours)
    {
        return this.coursService.addCours(cours);
    }
}
