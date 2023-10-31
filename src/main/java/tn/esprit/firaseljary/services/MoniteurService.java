package tn.esprit.firaseljary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.entitites.Moniteur;
import tn.esprit.firaseljary.repositories.CoursRepository;
import tn.esprit.firaseljary.repositories.MoniteurRepository;

@Service
@RequiredArgsConstructor
public class MoniteurService implements IMoniteurService{
    private final MoniteurRepository moniteurRepository ;
    private final CoursRepository coursRepository ;
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, int numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        if (cours != null)
        {
            moniteur.getCoursSet().add(cours);
            return this.moniteurRepository.save(moniteur);
        }

        return null;
    }
}
