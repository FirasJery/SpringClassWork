package tn.esprit.firaseljary.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.firaseljary.entitites.Cours;

import java.util.List;

public interface CoursRepository extends CrudRepository<Cours , Integer> {

    @Query(value = "SELECT * FROM cours c " +
            "join moniteur_cours_set mc on c.num_cours = mc.cours_set_num_cours" +
            "join moniteur m on mc.moniteur_num_moniteur = m.num_moniteur " +
            "WHERE m.nomm = :nom And m.prenomm = :prenom ",nativeQuery = true)
    List<Cours> findByMoniteurNameSQLNative(@Param("nom") String nomM , @Param("prenom") String prenomM);

    //JPQL

    @Query("SELECT c FROM Cours c " +
            "join Moniteur m on c member m.coursSet " +
            "WHERE m.nomM = :nom And m.prenomM = :prenom ")
    List<Cours> findByMoniteurNameJPQL(@Param("nom") String nomM , @Param("prenom") String prenomM);
}
