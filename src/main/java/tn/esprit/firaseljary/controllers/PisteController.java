package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firaseljary.entitites.Piste;
import tn.esprit.firaseljary.services.IPisteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteController {
    private final IPisteService pisteService ;

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste)
    {
        return this.pisteService.addPiste(piste);
    }
}
