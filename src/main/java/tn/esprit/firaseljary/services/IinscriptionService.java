package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.enums.Support;

import java.util.List;

public interface IinscriptionService {

    Inscription addInscriptionAndAssignSkieur(Inscription inscription, int numSkieur);

    Inscription assignRegistrationToCourse(int numRegistration, int numCourse);


    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, int numSkieur, int numCours);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
