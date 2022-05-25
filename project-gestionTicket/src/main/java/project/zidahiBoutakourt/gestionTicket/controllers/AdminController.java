package project.zidahiBoutakourt.gestionTicket.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import project.zidahiBoutakourt.gestionTicket.models.Ticket;
import project.zidahiBoutakourt.gestionTicket.repositories.TicketRepository;
import project.zidahiBoutakourt.gestionTicket.security.services.SecurityUtils;
import project.zidahiBoutakourt.gestionTicket.services.AdminService;
import project.zidahiBoutakourt.gestionTicket.services.DeveloppeurService;

@Controller
@RequestMapping("/adminss")
public class AdminController {
	 private AdminService adminService;
	 private DeveloppeurService developpeurService;
	 private static  long idTicket;
	 @Autowired
	 TicketRepository ticketRepository;
	    public AdminController(AdminService adminService,DeveloppeurService developpeurService) {
	        this.adminService = adminService;
	        this.developpeurService=developpeurService;
	    }
	    
	    @GetMapping("/bugs")
	    public List<Ticket> get(){
	    	return adminService.findAllTicketNonAttribuer();
	    }
	    @GetMapping("/getbugs")
	    public String getTicket(Model model){
	    	
	    	 model.addAttribute("listTickets" ,adminService.findAllTicketNonAttribuer() );
	    	
	    	 return "bugs";
	    }
	    @GetMapping("/listAffectations")
	    public String listAffectations(Model model){
	    	
	    	 model.addAttribute("listAffectations" ,adminService.listeAffectations(adminService.findIdAdminByNom(SecurityUtils.getUserName())) );
	    	
	    	 return "listeAffectation";
	    }
	    
	    
	    
	    
	    @GetMapping("/save")
	    public String save(Model model,@ModelAttribute("nomDeveloppeur") String nomDeveloppeur, BindingResult bindingResult){
	    
	        if (bindingResult.hasErrors()) {
	           

	            return "affecterTicket";
	        }
	System.out.println("iddd ticket : "+idTicket);
	System.out.println(nomDeveloppeur);
	System.out.println("iddd dev : "+developpeurService.findIdByUsername(nomDeveloppeur));
	System.out.println("iddd admin : "+adminService.findIdAdminByNom(SecurityUtils.getUserName()));

	
	    	adminService.AttribuerTicket(developpeurService.findIdByUsername(nomDeveloppeur),adminService.findIdAdminByNom(SecurityUtils.getUserName()),idTicket);

	        return "redirect:/adminss/getbugs";
	    }
	   
	    @PutMapping("/modifier")
	    public void modifier(@RequestBody Ticket newTicket) {
	    	
	    	ticketRepository.save(newTicket);
	    }
	    
	    
	    
	    @GetMapping("/affecterTicket")
	    public String affecterTicket(Model model,Long id_ticket) {
	    	idTicket=id_ticket;
	    	model.addAttribute("nomDeveloppeur",new String());
	        model.addAttribute("listDeveloppeur",developpeurService.findAll());
	       
	        return "affecterTicket";
	    	
	    }
}
