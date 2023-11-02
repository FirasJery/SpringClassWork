package tn.esprit.firaseljary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.esprit.firaseljary.entitites.*;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
import tn.esprit.firaseljary.repositories.*;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SkieurService implements ISkieurService {

    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;
    private final AbonnementRepository abonnementRepository ;

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
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public void deleteOneById(int id) {
        skieurRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Skieur assignSkierToPiste(int numSkieur, int numPiste) {
        Piste piste = this.pisteRepository.findById(numPiste).orElse(null);
        Skieur skieur = null;
        if (piste != null) {
            skieur = this.skieurRepository.findById(numSkieur).orElse(null);
            if (skieur != null) {
                //Set<Piste> edited = skieur.getSetPiste();
                //edited.add(piste);
                skieur.getSetPiste().add(piste);
             //   return this.skieurRepository.save(skieur);
            }
        }
        return skieur;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, int numCourse) {
           Cours cours =  this.coursRepository.findById(numCourse).orElse(null);

           if (cours != null)
           {
               Abonnement abonnement = skieur.getAbonnement();
               Assert.notNull(abonnement,"abonnement null ! ");
               this.abonnementRepository.save(abonnement); // use cascade in the entity to add abonnement automatically
               this.skieurRepository.save(skieur);
               Inscription inscription = skieur.getSetInscription().stream()
                       .findFirst()
                       .orElseThrow(() -> new IllegalArgumentException("inscription not found ! "));
               inscription.setSkieur(skieur);
               inscription.setCours(cours);
               this.inscriptionRepository.save(inscription);
               return skieur;
           }


        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }
}
