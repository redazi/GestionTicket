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
@DiscriminatorValue("A")
public class Admin extends Personne {

	private String matricule_admin;

	public String getMatricule_admin() {
		return matricule_admin;
	}

	public void setMatricule_admin(String matricule_admin) {
		this.matricule_admin = matricule_admin;
	}
	



	
}
