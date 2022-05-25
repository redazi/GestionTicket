package project.zidahiBoutakourt.gestionTicket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.zidahiBoutakourt.gestionTicket.models.Client;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientControllerRest {
	  private ClientService clientService;

	    public ClientControllerRest(ClientService clientService) {
	        this.clientService = clientService;
	    }

	    
	    @PostMapping("/addticket")
	    public void ajouter(@RequestBody Ticket t) {
	    	clientService.addTicket(t);
	    	
	    	
	    }
	    @PostMapping("/addclient")
	    public void ajouter(@RequestBody Client c) {
	    	clientService.AddClient(c);
	    	
	    	
	    }
	    @GetMapping
	    public List<Client> get(){
	    	return clientService.findAll();
	    }
	    @GetMapping("/getTicket/{id}")
	    public List<Ticket> getTicket(@PathVariable long id){
	    	return clientService.findAll_byIdCLIENT(id);
	    }
	    /*
	    @GetMapping
	    public List<Ticket> get(){
	    	return utilisateurRepository.findAll();
	    }
	    */
	    
}
