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
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int numMoniteur ;
    String nomM ;
    String prenomM ;
    Date dateRecu ;
    @OneToMany
    Set<Cours> coursSet ;



}
