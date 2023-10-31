package tn.esprit.firaseljary.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.repositories.CoursRepository;
import tn.esprit.firaseljary.repositories.InscriptionRepository;
import tn.esprit.firaseljary.repositories.SkieurRepository;

@Service
@RequiredArgsConstructor
public class InscriptionService implements IinscriptionService {


    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Inscription addInscriptionAndAssignSkieur(Inscription inscription, int numSkieur) {
        Skieur skieur = this.skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);
        if (skieur != null) {
            return this.inscriptionRepository.save(inscription);
        }
        return null;
    }

    @Override
    public Inscription assignRegistrationToCourse(int numRegistration, int numCourse) {
        Cours course = this.coursRepository.findById(numCourse).orElse(null);
        Inscription inscription = this.inscriptionRepository.findById(numRegistration).orElse(null);
        if (inscription != null) {
            inscription.setCours(course);
            if (course != null) {
                return this.inscriptionRepository.save(inscription);
            }
        }
        return null;
    }
}
