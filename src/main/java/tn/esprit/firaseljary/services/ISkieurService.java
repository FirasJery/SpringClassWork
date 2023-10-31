package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    Skieur addSkieur(Skieur skieur);
    Skieur FindOneById(int id);
    Skieur updateSkieur(Skieur skieur);
    List<Skieur> findAll();
    void deleteOneById(int id);
    Skieur assignSkierToPiste(int numSkieur, int numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skieur, int numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
