package tn.esprit.firaseljary.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.controllers.CustomException;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.Support;
import tn.esprit.firaseljary.entitites.enums.TypeCours;
import tn.esprit.firaseljary.repositories.CoursRepository;
import tn.esprit.firaseljary.repositories.InscriptionRepository;
import tn.esprit.firaseljary.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscriptionService implements IinscriptionService {


    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Inscription addInscriptionAndAssignSkieur(Inscription inscription, int numSkieur) {
        Skieur skieur = this.skieurRepository.findById(numSkieur).orElseThrow(() -> new CustomException("Skieur not found !"));
        inscription.setSkieur(skieur);
        return this.inscriptionRepository.save(inscription);
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

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, int numSkieur, int numCours) {
        Skieur skieur = this.skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new CustomException("Skieur not found !"));
        LocalDate localDate = skieur.getDateNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period age = Period.between(localDate, LocalDate.now());
        int ageInYears = age.getYears();
        if (ageInYears < 6) {
            throw new CustomException("age not valid !");
        }
        Cours cours = this.coursRepository.findById(numCours).orElseThrow(() -> new CustomException("Cours not found !"));
        Long countByCours = this.inscriptionRepository.countByCours(cours);
        if ((cours.getTypeCours() == TypeCours.Collectif_enfant || cours.getTypeCours() == TypeCours.Collectif_adulte)
                && (countByCours >= 6)) {
            throw new CustomException("Cours complet !");
        }
        inscription.setCours(cours);
        inscription.setSkieur(skieur);
        this.inscriptionRepository.save(inscription);
        return inscription;
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        List<Inscription> list = this.inscriptionRepository.numWeeksCourseOfInstructorBySupport(numInstructor, support);
        return list.stream().map(Inscription::getNumSemaine).toList();
    }
}
