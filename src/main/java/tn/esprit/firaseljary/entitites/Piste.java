package tn.esprit.firaseljary.entitites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.firaseljary.entitites.enums.Couleur;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numPiste ;
    String nomPiste ;
    @Enumerated(EnumType.STRING)
    Couleur couleur ;
    int longeur ;
    int pente ;
}
