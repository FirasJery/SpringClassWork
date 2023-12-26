package tn.esprit.firaseljary.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.firaseljary.entitites.enums.Support;
import tn.esprit.firaseljary.entitites.enums.TypeCours;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numCours ;
    int niveau ;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours ;
    @Enumerated(EnumType.STRING)
    Support support ;
    float prix ;
    int creneau ;



    @JsonIgnore
    @OneToMany(mappedBy = "cours")
    Set<Inscription> setInscriptions ;

}
