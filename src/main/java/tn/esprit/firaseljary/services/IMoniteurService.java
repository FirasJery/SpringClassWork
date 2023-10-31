package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Moniteur;

public interface IMoniteurService {


    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, int numCourse);
}
