package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Cours;

import java.util.List;

public interface ICoursService {

    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);
    Cours findOneById(int id);
    List<Cours> findAll();
    void deleteOneById(int id);

}
