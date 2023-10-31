package tn.esprit.firaseljary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.entitites.Moniteur;
import tn.esprit.firaseljary.repositories.CoursRepository;
import tn.esprit.firaseljary.repositories.MoniteurRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MoniteurService implements IMoniteurService{
    private final MoniteurRepository moniteurRepository ;
    private final CoursRepository coursRepository ;

    @Override
    public Moniteur addInstructor(Moniteur moniteur) {
        return this.moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, int numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        if (cours != null)
        {
            Set<Cours> edited = new HashSet<>();
            edited.add(cours);
            moniteur.setCoursSet(edited);
            return this.moniteurRepository.save(moniteur);
        }

        return null;
    }
}
