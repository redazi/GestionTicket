package project.zidahiBoutakourt.gestionTicket.security.services;

import project.zidahiBoutakourt.gestionTicket.security.entities.AppRole;
import project.zidahiBoutakourt.gestionTicket.security.entities.AppUser;

public interface SecurityService {

    AppUser saveNewUser(String username, String password, String rePassword);

    AppRole saveNewRole(String roleName, String description);

    void addRoleToUser(String username, String roleName);

    void deleteRoleFromUser(String username, String roleName);

    AppUser loadUserByUsername(String username);

}
