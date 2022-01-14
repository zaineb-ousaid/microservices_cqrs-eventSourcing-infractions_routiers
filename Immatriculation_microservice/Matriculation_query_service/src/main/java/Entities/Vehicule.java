package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
 long id;
 String numMatricul;
 String marque;
 double puissanceFiscal;
 String model;
 @OneToOne
 Proprietaire proprietaire;
}
