package project.zidahiBoutakourt.gestionTicket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import project.zidahiBoutakourt.gestionTicket.models.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {
	Ticket findById(long id);
}
