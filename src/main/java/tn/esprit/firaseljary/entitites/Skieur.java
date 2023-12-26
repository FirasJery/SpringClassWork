package tn.esprit.firaseljary.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numSkieur ;
    String nomS ;
    String prenomS ;
    Date dateNaissance ;
    String ville;



    @OneToMany(mappedBy = "skieur",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set<Inscription> setInscription ;


    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Abonnement abonnement ;


    @ManyToMany()
    Set<Piste> setPiste ;

}
