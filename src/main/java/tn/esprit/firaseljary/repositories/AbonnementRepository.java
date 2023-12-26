package tn.esprit.firaseljary.repositories;



import org.springframework.data.repository.CrudRepository;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends CrudRepository<Abonnement, Integer> {
    Set<Abonnement> findByTypeAbonAndTypeAbonIsNotNullOrderByDateDebutAsc(TypeAbonnement type);
    List<Abonnement> findByDateDebutIsLessThanAndDateFinGreaterThan(Date dateDebut, Date dateFin);

    List<Abonnement> findByDateFinIsBetween(Date now , Date afterWeek);
}
