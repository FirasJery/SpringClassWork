package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
import tn.esprit.firaseljary.services.IAbonnementService;


import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("abonnement")
public class AbonnementController {
    private final IAbonnementService abonnementService;

    @GetMapping("/filter/{typeAbonnement}")
    public Set<Abonnement> getSubscriptionByType(@PathVariable TypeAbonnement typeAbonnement)
    {
        return this.abonnementService.getSubscriptionByType(typeAbonnement);
    }
    @GetMapping("/filter/{dateDebut}/{DateFin}")
    public List<Abonnement> getSubscriptionByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateFin)
    {
        return this.abonnementService.retrieveSubscriptionsByDates(dateDebut,DateFin);
    }


}
