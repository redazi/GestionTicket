package project.zidahiBoutakourt.gestionTicket.services;

import java.util.List;


import project.zidahiBoutakourt.gestionTicket.models.Client;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;



public interface ClientService {
	   List<Ticket> findAll_byIdCLIENT(long id);
	    List<Client> findAll();
	    
	   Client getById(Long id);
	   
	   Client AddClient(Client client);

	   Ticket addTicket(Ticket ticket);

	   Ticket updateTicket(Ticket ticket);
        long findIdByUsername(String nom);
	    void supprimerTicket(Long id);

}
