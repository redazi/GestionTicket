package project.zidahiBoutakourt.gestionTicket.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.zidahiBoutakourt.gestionTicket.security.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
