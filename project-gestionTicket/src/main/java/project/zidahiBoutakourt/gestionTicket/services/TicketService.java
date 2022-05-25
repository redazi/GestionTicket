package project.zidahiBoutakourt.gestionTicket.services;

import java.util.List;


import project.zidahiBoutakourt.gestionTicket.models.Ticket;

public interface TicketService {
	   List<Ticket> findAll();

	   Ticket getById(Long id);

	   Ticket ajouterTicket(Ticket ticket);

	   Ticket updateTicket(Ticket ticket);

	    void supprimerTicket(Long id);
}
