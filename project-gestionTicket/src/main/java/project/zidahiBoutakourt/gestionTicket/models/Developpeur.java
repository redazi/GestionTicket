package project.zidahiBoutakourt.gestionTicket.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("D")
public class Developpeur extends Personne {
	
	
	private String matricule_developpeur;

	public String getMatricule_developpeur() {
		return matricule_developpeur;
	}

	public void setMatricule_developpeur(String matricule_developpeur) {
		this.matricule_developpeur = matricule_developpeur;
	}
	
	
	


	
	
	

}
