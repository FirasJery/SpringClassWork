package tn.esprit.firaseljary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.repositories.CoursRepository;

import java.util.List;

@Service
public class CoursService implements ICoursService{

    @Autowired
    CoursRepository coursRepository ;
    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours findOneById(int id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cours> findAll() {
        return (List<Cours>)coursRepository.findAll();
    }

    @Override
    public void deleteOneById(int id) {
        coursRepository.deleteById(id);
    }
}
