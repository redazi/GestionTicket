package project.zidahiBoutakourt.gestionTicket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import project.zidahiBoutakourt.gestionTicket.security.services.SecurityService;



@SpringBootApplication
public class ProjectGestionTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGestionTicketApplication.class, args);
	}
	 @Bean
	    PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    //@Bean
	    CommandLineRunner saveUsers(SecurityService securityService){
	        return args -> {
	           /* securityService.saveNewUser("reda", "123", "123");
	            securityService.saveNewUser("dev", "123", "123");
	            securityService.saveNewUser("client", "123", "123");
	            securityService.saveNewUser("reda15", "123", "123");
	            securityService.saveNewRole("ADMIN", "Admin");
	            securityService.saveNewRole("DEVELOPPEUR", "Developpeur");
	            securityService.saveNewRole("CLIENT", "client");
	            
	            securityService.addRoleToUser("reda", "ADMIN");
	            securityService.addRoleToUser("dev", "DEVELOPPEUR");
	            securityService.addRoleToUser("client", "CLIENT");
	            securityService.addRoleToUser("reda15", "CLIENT");
	            
	            */
	        	
	        	securityService.saveNewUser("dev1", "123", "123");
	        	securityService.saveNewUser("dev2", "123", "123");
	        	  securityService.addRoleToUser("dev1", "DEVELOPPEUR");
	        	  securityService.addRoleToUser("dev2", "DEVELOPPEUR");
	        };
	    }
}
