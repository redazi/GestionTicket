package project.zidahiBoutakourt.gestionTicket.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.security.services.SecurityUtils;
import project.zidahiBoutakourt.gestionTicket.services.DeveloppeurService;

@Controller
@RequestMapping("/developpeurss")
public class DeveloppeurController {
	 private DeveloppeurService developpeurService;
	 private static  long id_Ticket;
	    public DeveloppeurController(DeveloppeurService developpeurService) {
	        this.developpeurService = developpeurService;
	    }
	    
	    @GetMapping("/updateStatus")
	    public String updateStatus(Long id_ticket,Model model ) {
	    	System.out.println("redaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa is heere");
	    	
	    	id_Ticket=id_ticket;
	    	model.addAttribute("nomStatus",new String());
	       
	       
	        return "updateStatus";
	    	  
	    	
	    	
	    	
	    }
	 
	    @GetMapping("/save")
	    public String save(Model model,@ModelAttribute("nomStatus") String nomStatus, BindingResult bindingResult){
	    
	        if (bindingResult.hasErrors()) {
	           

	        	return "updateStatus";
	        }
			
	System.out.println("iddd ticket : "+id_Ticket);
	developpeurService.updateStatus(nomStatus,id_Ticket);

	        return "redirect:/developpeurss/listerTicket";
	    }
	   
	    @GetMapping("/getTicket/{id}")
	    public List<Ticket> getTicket(@PathVariable long id){
	    	return developpeurService.findAll_byIdDev(id);
	    }
	    
	    @GetMapping("/listerTicket")
	    public String listerTicket(Model model) {
	    	
	    
	        model.addAttribute("listTickets",developpeurService.findAll_byIdDev(developpeurService.findIdByUsername(SecurityUtils.getUserName())));
	       
	        return "listeTicketDev";
	    	
	    }
	    
	    
}
