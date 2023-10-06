package tn.esprit.firaseljary.services;

import tn.esprit.firaseljary.entitites.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste findOneById(int id );
    List<Piste> findAll();
    void deleteOneById(int id );
}
