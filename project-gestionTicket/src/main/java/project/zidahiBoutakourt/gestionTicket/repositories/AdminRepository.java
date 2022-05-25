package project.zidahiBoutakourt.gestionTicket.repositories;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.zidahiBoutakourt.gestionTicket.models.Admin;
import project.zidahiBoutakourt.gestionTicket.models.Ticket;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	@Query("SELECT u FROM Ticket u WHERE u.developpeur.id  = null")
	Collection<Ticket> findAllTicketNAttr();
	@Query("SELECT u FROM Ticket u WHERE u.admin.id  = ?1")
	Collection<Ticket> listeAffectations(long id);
	@Query("SELECT u.id FROM Personne u WHERE type='A' and u.username   = ?1")
	long findIdAdminByNom(String nom);
	
	
	
	
	 @Modifying
	    @Query(value = "update Ticket u set u.developpeur.id= :id_dev and u.admin.id=:id_ad where u.id_ticket = :id_tic", nativeQuery = true)
	    @Transactional
	    Integer AttrTicket( long id_dev,long id_ad, long id_tic);
	 
	 
}
