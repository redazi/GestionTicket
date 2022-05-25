package project.zidahiBoutakourt.gestionTicket.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_ticket;
private String priority;
private String description;
private String urgence;
private String status;
private String environnement;
private String logiciel;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date_creation;


@ManyToOne 
private Client client;
@JsonProperty("client_id")
private void unpackNested(long client_id) {
    this.client = new Client();
    client.setId(client_id);
}
@ManyToOne 
private Admin admin;
@JsonProperty("admin_id")
private void unpackNested1(long admin_id) {
    this.admin = new Admin();
    admin.setId(admin_id);
}

@ManyToOne 
private Developpeur developpeur;
@JsonProperty("developpeur_id")
private void unpackNested2(long developpeur_id) {
    this.developpeur = new Developpeur();
    developpeur.setId(developpeur_id);
}

public long getId_ticket() {
	return id_ticket;
}

public void setId_ticket(long id_ticket) {
	this.id_ticket = id_ticket;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getUrgence() {
	return urgence;
}

public void setUrgence(String urgence) {
	this.urgence = urgence;
}

public String getEnvironnement() {
	return environnement;
}

public void setEnvironnement(String environnement) {
	this.environnement = environnement;
}

public String getLogiciel() {
	return logiciel;
}

public void setLogiciel(String logiciel) {
	this.logiciel = logiciel;
}

public Date getDate_creation() {
	return date_creation;
}

public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}



public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
}

public Developpeur getDeveloppeur() {
	return developpeur;
}

public void setDeveloppeur(Developpeur developpeur) {
	this.developpeur = developpeur;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	

}
