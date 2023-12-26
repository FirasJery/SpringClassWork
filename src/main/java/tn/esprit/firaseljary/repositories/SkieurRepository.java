package tn.esprit.firaseljary.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.Couleur;
import tn.esprit.firaseljary.entitites.enums.Support;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
import tn.esprit.firaseljary.entitites.enums.TypeCours;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur, Integer> {
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);

    List<Skieur> findByAbonnementTypeAbonAndSetPisteCouleurAndSetInscriptionCoursTypeCoursAndSetInscriptionCoursSupport(TypeAbonnement abonnement_typeAbon, Couleur setPiste_couleur, TypeCours setInscription_cours_typeCours, Support setInscription_cours_support);

    Skieur findByAbonnement_NumAbon(int abonnement_numAbon);
}
