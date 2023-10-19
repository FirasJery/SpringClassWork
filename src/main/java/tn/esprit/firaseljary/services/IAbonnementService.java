package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Abonnement;

import java.util.List;

public interface IAbonnementService {

    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnemet(Abonnement abonnement);
    Abonnement findById(int id );
    List<Abonnement> findAll();

    void deleteAbonnementById(int id);
}
