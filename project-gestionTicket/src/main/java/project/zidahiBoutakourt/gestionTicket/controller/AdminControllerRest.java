package project.zidahiBoutakourt.gestionTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.zidahiBoutakourt.gestionTicket.models.Client;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.repositories.TicketRepository;
import project.zidahiBoutakourt.gestionTicket.services.AdminService;
import project.zidahiBoutakourt.gestionTicket.services.ClientService;

@RestController
@RequestMapping("/admins")
public class AdminControllerRest {
	 private AdminService adminService;
	 @Autowired
	 TicketRepository ticketRepository;
	    public AdminControllerRest(AdminService adminService) {
	        this.adminService = adminService;
	    }
	    
	    @GetMapping("/bugs")
	    public List<Ticket> get(){
	    	return adminService.findAllTicketNonAttribuer();
	    }
	    
	   
	    @PutMapping("/modifier")
	    public void modifier(@RequestBody Ticket newTicket) {
	    	
	    	ticketRepository.save(newTicket);
	    }
	    
	    @PutMapping("/affecterTicket")
	    public void affecterTicket(@RequestBody Ticket t ) {
	    	adminService.AttribuerTicket(t.getDeveloppeur().getId(),t.getAdmin().getId(),t.getId_ticket());
	    	
	    	
	    }
}
