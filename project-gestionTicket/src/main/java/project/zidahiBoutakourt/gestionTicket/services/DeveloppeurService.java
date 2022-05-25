package project.zidahiBoutakourt.gestionTicket.services;

import java.util.List;


import project.zidahiBoutakourt.gestionTicket.models.Developpeur;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;

public interface DeveloppeurService {

	 void updateStatus (String status, long id_tic);
	List<Ticket> findAll_byIdDev(Long id);
	 Long findIdByUsername(String nom);
	  List<Developpeur> findAll();
}
