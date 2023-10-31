package tn.esprit.firaseljary.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur, Integer> {
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
}
