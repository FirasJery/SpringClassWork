package tn.esprit.firaseljary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
import tn.esprit.firaseljary.services.IAbonnementService;

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
}
