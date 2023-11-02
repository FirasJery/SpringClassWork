package tn.esprit.firaseljary.repositories;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;

import java.util.Date;
import java.util.Set;

public interface AbonnementRepository extends CrudRepository<Abonnement, Integer> {
    Set<Abonnement> findByTypeAbonAndTypeAbonIsNotNullOrderByDateDebutAsc(TypeAbonnement type);
    Set<Abonnement> findByTypeAbonAndDateDebutBetween(TypeAbonnement typeAbon, Date dateDebut, Date dateDebut2);
}
