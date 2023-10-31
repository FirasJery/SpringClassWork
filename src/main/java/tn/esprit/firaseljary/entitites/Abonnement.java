package tn.esprit.firaseljary.entitites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.firaseljary.entitites.enums.TypeAbonnement;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numAbon ;
    Date dateDebut ;
    Date dateFin ;
    float prixAbon ;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbon ;
}
