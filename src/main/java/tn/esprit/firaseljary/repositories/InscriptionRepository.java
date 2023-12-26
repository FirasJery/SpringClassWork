package tn.esprit.firaseljary.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.firaseljary.entitites.Cours;
import tn.esprit.firaseljary.entitites.Inscription;
import tn.esprit.firaseljary.entitites.enums.Support;

import java.util.List;

public interface InscriptionRepository extends CrudRepository<Inscription, Integer> {

            Long countByCours(Cours cours);
    @Query("select i from Inscription i " +
            " join Cours c on i member of c.setInscriptions " +
            " join Moniteur m on c member of m.coursSet " +
            " where m.numMoniteur = :numInstructor and c.support = :support")
    List<Inscription> numWeeksCourseOfInstructorBySupport(@Param("numInstructor") Long numInstructor,@Param("support") Support support);
}