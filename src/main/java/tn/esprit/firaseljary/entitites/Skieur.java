package tn.esprit.firaseljary.entitites;

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
    int NumSkieur ;
    String NomS ;
    String PrenomS ;
    Date dateNaissance ;
    String ville;
    @OneToMany(mappedBy = "skieur")
    Set<Inscription> SetInscription ;
    @OneToOne()
    Abonnement abonnement ;
    @ManyToMany()
    Set<Piste> SetPiste ;

}
