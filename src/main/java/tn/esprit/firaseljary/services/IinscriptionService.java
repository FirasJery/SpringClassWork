package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Inscription;

public interface IinscriptionService {

    Inscription addInscriptionAndAssignSkieur(Inscription inscription, int numSkieur);

    Inscription assignRegistrationToCourse(int numRegistration, int numCourse);
}
