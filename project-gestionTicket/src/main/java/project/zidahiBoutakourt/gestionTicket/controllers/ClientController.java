package project.zidahiBoutakourt.gestionTicket.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import project.zidahiBoutakourt.gestionTicket.models.Client;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.security.services.SecurityService;
import project.zidahiBoutakourt.gestionTicket.security.services.SecurityUtils;
import project.zidahiBoutakourt.gestionTicket.services.ClientService;

@Controller
@RequestMapping("/clientss")
public class ClientController {
	 private ClientService clientService;
	 private SecurityService securityService;

	    public ClientController(ClientService clientService) {
	        this.clientService = clientService;
	    }

	    
	    @PostMapping("/addticket")
	    public void ajouter(@RequestBody Ticket t) {
	    	clientService.addTicket(t);
	    	
	    	
	    }
		@GetMapping("/home")
		public String index(Model model){
			
				
			return "index";
		}

		@GetMapping("/all")
		public String findall(Model model){
			model.addAttribute("listClients" ,clientService.findAll());
				
			return "clients";
		}
	    @GetMapping("/index")
	    public String client(Model model) {
			model.addAttribute("listTickets" ,clientService.findAll_byIdCLIENT(clientService.findIdByUsername(SecurityUtils.getUserName())) );
	    	
			 model.addAttribute("ticket", new Ticket());
	    	// System.out.println("username is :"+SecurityUtils.getUserName()+" est son id :"+clientService.findIdByUsername(SecurityUtils.getUserName()));
	    	 
		        return "addTicketClient";
		}
	       
	    
	    @PostMapping("/addclient")
	    public void ajouter(@RequestBody Client c) {
	    	clientService.AddClient(c);
	    	
	    	
	    }
	    @GetMapping("/save")
	    public String save(Model model, @Valid Ticket ticket, BindingResult bindingResult){
	        if (bindingResult.hasErrors()) {
	            return "addTicket";
	        }
	        Client c = clientService.getById(clientService.findIdByUsername(SecurityUtils.getUserName()));
	        ticket.setClient(c);
	        ticket.setStatus("en attente");
	        model.addAttribute(clientService.addTicket(ticket));
	        return "redirect:/clientss/index";
	    }
	    @GetMapping
	    public List<Client> get(){
	    	return clientService.findAll();
	    }
	    @GetMapping("/addTicket")
	    public String formSyndic(Model model){
	        model.addAttribute("ticket", new Ticket());
	        return "addTicketClient";
	    }

	    @GetMapping("/getTicket")
	    public String getTicket(Model model){
	    	
	    	 model.addAttribute("listTickets" ,clientService.findAll_byIdCLIENT(clientService.findIdByUsername(SecurityUtils.getUserName())) );
	    	
	    	 return "ticketClient";
	    }
	    /*
	    @GetMapping
	    public List<Ticket> get(){
	    	return utilisateurRepository.findAll();
	    }
	    */
}
