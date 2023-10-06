package tn.esprit.firaseljary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Piste;
import tn.esprit.firaseljary.repositories.PisteRepository;

import java.util.List;

@Service
public class PisteService implements IPisteService{

    @Autowired
    PisteRepository pisteRepository ;

    // TO DO
    @Override
    public Piste addPiste(Piste piste) { // update specific fields
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste findOneById(int id) {
        //return pisteRepository.findById(id).orElse(null);
        return pisteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Piste found with this id ! "));

    }

    @Override
    public List<Piste> findAll() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public void deleteOneById(int id) {
        pisteRepository.deleteById(id);
    }
}
