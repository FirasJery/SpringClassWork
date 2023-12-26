package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;


import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {

    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnemet(Abonnement abonnement);
    Abonnement findById(int id );
    List<Abonnement> findAll();
    void deleteAbonnementById(int id);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(Date startDate, Date endDate);

    void retrieveSubscriptions();
}
