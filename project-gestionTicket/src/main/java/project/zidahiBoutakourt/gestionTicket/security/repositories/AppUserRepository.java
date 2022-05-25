package project.zidahiBoutakourt.gestionTicket.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.zidahiBoutakourt.gestionTicket.security.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
