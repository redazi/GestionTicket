package project.zidahiBoutakourt.gestionTicket.security.services;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.zidahiBoutakourt.gestionTicket.security.entities.AppRole;
import project.zidahiBoutakourt.gestionTicket.security.entities.AppUser;
import project.zidahiBoutakourt.gestionTicket.security.repositories.AppRoleRepository;
import project.zidahiBoutakourt.gestionTicket.security.repositories.AppUserRepository;

@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public SecurityServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if (!password.equals(rePassword)) throw new RuntimeException("Not Matched Passwords");
        String hashedPWD = passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUSer = appUserRepository.save(appUser);
        return savedAppUSer;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole != null) {throw new RuntimeException("Role " + roleName + "Already Exists");}
        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole = appRoleRepository.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role Not Found");
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User Not Found");
        appUser.getAppRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteRoleFromUser(String username, String roleName) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role Not Found");
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User Not Found");
        appUser.getAppRoles().remove(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
