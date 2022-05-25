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
@DiscriminatorValue("C")
public class Client extends Personne {

private String matricule_client;

public String getMatricule_client() {
	return matricule_client;
}

public void setMatricule_client(String matricule_client) {
	this.matricule_client = matricule_client;
}






}
