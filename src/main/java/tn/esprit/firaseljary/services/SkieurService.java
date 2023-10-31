package tn.esprit.firaseljary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firaseljary.entitites.Piste;
import tn.esprit.firaseljary.entitites.Skieur;
import tn.esprit.firaseljary.repositories.PisteRepository;
import tn.esprit.firaseljary.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class SkieurService implements ISkieurService {

    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;

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

    @Override
    public Skieur assignSkierToPiste(int numSkieur, int numPiste) {
        Piste piste = this.pisteRepository.findById(numPiste).orElse(null);
        Skieur skieur = null;
        if (piste != null) {
            skieur = this.skieurRepository.findById(numSkieur).orElse(null);
            if (skieur != null) {
                Set<Piste> edited = skieur.getSetPiste();
                edited.add(piste);
                skieur.setSetPiste(edited);
                return this.skieurRepository.save(skieur);
            }
        }
        return skieur;
    }
}
