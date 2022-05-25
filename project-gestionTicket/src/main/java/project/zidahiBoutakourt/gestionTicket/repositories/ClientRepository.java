package project.zidahiBoutakourt.gestionTicket.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.zidahiBoutakourt.gestionTicket.models.Client;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;



public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("SELECT u FROM Ticket u WHERE u.client.id  = ?1")
	Collection<Ticket> findAllTicketClient(long id);
	@Query("SELECT u.id FROM Personne u WHERE u.nom  = ?1")
	long findIdClientByNom(String nom);
}
