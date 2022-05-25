package project.zidahiBoutakourt.gestionTicket.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.zidahiBoutakourt.gestionTicket.models.Developpeur;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.repositories.ClientRepository;
import project.zidahiBoutakourt.gestionTicket.repositories.DeveloppeurRepository;
import project.zidahiBoutakourt.gestionTicket.repositories.TicketRepository;
@Service
@Transactional
public class DeveloppeurServiceImpl implements DeveloppeurService {
	  private TicketRepository ticketRepository;
	    private DeveloppeurRepository developpeurRepository;
		  public DeveloppeurServiceImpl(TicketRepository ticketRepository,DeveloppeurRepository developpeurRepository) {
		        this.ticketRepository = ticketRepository;
		        this.developpeurRepository = developpeurRepository;
		    }

	@Override
	public List<Ticket> findAll_byIdDev(Long id) {
		// TODO Auto-generated method stub
		return (List<Ticket>) developpeurRepository.findAllTicketDev(id);
	}

	@Override
	public void updateStatus(String status, long id_tic) {
		// TODO Auto-generated method stub
		
		
		Ticket myTicket = ticketRepository.findById(id_tic);
		myTicket.setStatus(status);
		 ticketRepository.save(myTicket);
	}

	@Override
	public Long findIdByUsername(String nom) {
		// TODO Auto-generated method stub
		 return developpeurRepository.findIdDevByNom(nom);
	}

	@Override
	public List<Developpeur> findAll() {
		// TODO Auto-generated method stub
		return developpeurRepository.findAll();
	}

	
	
	
}
