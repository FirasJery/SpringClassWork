package tn.esprit.firaseljary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Abonnement;
import tn.esprit.firaseljary.repositories.AbonnementRepository;

import java.util.List;

@Service
public class AbonnementService implements IAbonnementService{


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
}
