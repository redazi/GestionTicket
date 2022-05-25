package project.zidahiBoutakourt.gestionTicket.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.zidahiBoutakourt.gestionTicket.models.Developpeur;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;

public interface DeveloppeurRepository  extends JpaRepository<Developpeur, Long> {
	Developpeur findById(long id);
	@Query("SELECT u FROM Ticket u WHERE u.developpeur.id  = ?1")
	Collection<Ticket> findAllTicketDev(long id);
	
	@Query("SELECT u.id FROM Personne u WHERE u.nom  = ?1")
	Long findIdDevByNom(String nom);
	
	
	
	
}
