package id.com.service.mh.service;

import id.com.service.mh.dto.LoginDTO;
import id.com.service.mh.dto.UserDTO;
import id.com.service.mh.entity.shared.AppUser;
import org.springframework.security.core.Authentication;

public interface AuthService {
    UserDTO registerCustomer(AppUser user);
    UserDTO registerStaff(AppUser user);
    UserDTO registerSupervisor(AppUser user);
    UserDTO registerManager(AppUser user);
    LoginDTO login(AppUser user);
    UserDTO readUserByNik(String nik);
    UserDTO readUserByUserId(String userId);
    UserDTO getByToken(Authentication authentication);
    AppUser getAppUserByToken(Authentication authentication);

}