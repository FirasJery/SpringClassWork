package tn.esprit.firaseljary.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;
import tn.esprit.firaseljary.repositories.AbonnementRepository;
import tn.esprit.firaseljary.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AbonnementService implements IAbonnementService{

    private final SkieurRepository skieurRepository;
    @Autowired
    AbonnementRepository abonnementRepository ;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return this.abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnemet(Abonnement abonnement) {
        return null;
    }

    @Override
    public Abonnement findById(int id) {
        return null;
    }

    @Override
    public List<Abonnement> findAll() {
        return null;
    }

    @Override
    public void deleteAbonnementById(int id) {

    }
    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return this.abonnementRepository.findByTypeAbonAndTypeAbonIsNotNullOrderByDateDebutAsc(type);
    }

    public List<Abonnement> retrieveSubscriptionsByDates(Date startDate, Date endDate) {

        return this.abonnementRepository.findByDateDebutIsLessThanAndDateFinGreaterThan(startDate,endDate);
    }


    @Override
    @Scheduled(fixedRate = 10000)
    public void retrieveSubscriptions()
    {
        Date date = Date.from(LocalDate.now().plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.abonnementRepository.findByDateFinIsBetween(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),date).forEach(abonnement -> {
            Skieur skieur = this.skieurRepository.findByAbonnement_NumAbon(abonnement.getNumAbon());
            log.info("\nnum of abonnement expires in the next 7 days = " + abonnement.getNumAbon() + "\n" +
                    "Numskieur : " + skieur.getNumSkieur() + " Nom : " + skieur.getNomS() + " Prenom : " + skieur.getPrenomS() + "\n" );

        });

    }



}
