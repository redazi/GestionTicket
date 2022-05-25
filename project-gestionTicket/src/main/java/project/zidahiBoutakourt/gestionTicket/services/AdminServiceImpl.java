package project.zidahiBoutakourt.gestionTicket.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.zidahiBoutakourt.gestionTicket.models.Admin;
import project.zidahiBoutakourt.gestionTicket.models.Developpeur;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.repositories.AdminRepository;
import project.zidahiBoutakourt.gestionTicket.repositories.ClientRepository;
import project.zidahiBoutakourt.gestionTicket.repositories.DeveloppeurRepository;
import project.zidahiBoutakourt.gestionTicket.repositories.TicketRepository;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	 private TicketRepository ticketRepository;
	    private AdminRepository adminRepository;
	    private DeveloppeurRepository developpeurRepository;
		  public AdminServiceImpl(TicketRepository ticketRepository,AdminRepository adminRepository,DeveloppeurRepository developpeurRepository) {
		        this.ticketRepository = ticketRepository;
		        this.adminRepository = adminRepository;
		        this.developpeurRepository = developpeurRepository;
		    }

	@Override
	public List<Ticket> findAllTicketNonAttribuer() {
		// TODO Auto-generated method stub
		return (List<Ticket>) adminRepository.findAllTicketNAttr();
	}

	@Override
	public Ticket getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket ajouterTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AttribuerTicket(long id,long id_ad,long id_tic) {
		
	Developpeur dev = developpeurRepository.findById(id);
	Admin ad = adminRepository.getById(id_ad);
		Ticket myTicket = ticketRepository.findById(id_tic);
		myTicket.setAdmin(ad);
		myTicket.setDeveloppeur(dev);
		 ticketRepository.save(myTicket);
		
		 
	}

	@Override
	public void supprimerTicket(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AttribuerTicket(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long findIdAdminByNom(String nom) {
		// TODO Auto-generated method stub
		return adminRepository.findIdAdminByNom(nom);
	}

	@Override
	public Collection<Ticket> listeAffectations(long id) {
		// TODO Auto-generated method stub
		return adminRepository.listeAffectations(id);
	}

}
