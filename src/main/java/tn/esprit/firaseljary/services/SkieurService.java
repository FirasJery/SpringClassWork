package tn.esprit.firaseljary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.repositories.SkieurRepository;

import java.util.List;


@Service
public class SkieurService implements ISkieurService{


    @Autowired
    SkieurRepository skieurRepository ;
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur FindOneById(int id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> findAll() {
        return (List<Skieur>)skieurRepository.findAll();
    }

    @Override
    public void deleteOneById(int id) {
            skieurRepository.deleteById(id);
    }
}
