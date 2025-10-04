package id.com.service.mh.service.impl;

import id.com.service.mh.dto.LoginDTO;
import id.com.service.mh.dto.UserDTO;
import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.entity.shared.Role;
import id.com.service.mh.repository.AppUserRepository;
import id.com.service.mh.security.JwtUtils;
import id.com.service.mh.service.AuthService;
import id.com.service.mh.service.RoleService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static id.com.service.mh.enums.ERole.*;

@Service
public class AuthServiceImpl implements AuthService {

    private  final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final AppUserRepository appUserRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final RoleService roleService;

    @Autowired
    public AuthServiceImpl(AppUserRepository appUserRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, RoleService roleService) {
        this.appUserRepository = appUserRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.roleService = roleService;
    }

    @Override
    public UserDTO registerCustomer(AppUser user) {
        Role role = roleService.getOrSaveRole(ROLE_CUSTOMER);
        user.setRoles(Arrays.asList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser appUser = appUserRepository.save(user);
        return new UserDTO(appUser);
    }

    @Override
    public UserDTO registerStaff(AppUser user) {
        Role role = roleService.getOrSaveRole(ROLE_STAFF);
        user.setRoles(Arrays.asList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser appUser = appUserRepository.save(user);
        return new UserDTO(appUser);
    }

    @Override
    public UserDTO registerSupervisor(AppUser user) {
        Role role = roleService.getOrSaveRole(ROLE_SUPERVISOR);
        user.setRoles(Arrays.asList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser appUser = appUserRepository.save(user);
        return new UserDTO(appUser);
    }

    @Override
    public UserDTO registerManager(AppUser user) {
        Role role = roleService.getOrSaveRole(ROLE_MANAGER);
        user.setRoles(Arrays.asList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser appUser = appUserRepository.save(user);
        return new UserDTO(appUser);
    }

    @Override
    public LoginDTO login(AppUser user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getNik(),
                        user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtils.generateTokenFromUsername(userDetails.getUsername());

        log.info("User {} logged in at {}", user.getNik(),new Date());

        return new LoginDTO(userDetails, token);
    }

    @Override
    public UserDTO readUserByNik(String nik) {
        if (appUserRepository.findByNik(nik).isPresent()){
            AppUser appUser = appUserRepository.findByNik(nik).get();
            UserDTO userDTO = new UserDTO(appUser);
            userDTO.setNik(appUser.getNik());
            return new UserDTO(appUser);
        }  else{
            throw new DataNotFoundException("Error");
        }
    }

    @Override
    public UserDTO readUserByUserId(String userId) {
        if (appUserRepository.findByUserId(userId).isPresent()){
            AppUser appUser = appUserRepository.findByUserId(userId).get();
            UserDTO userDTO = new UserDTO(appUser);
            userDTO.setNik(appUser.getNik());
            return  new UserDTO(appUser);
        } else {
            throw new DataNotFoundException("Error");
        }
    }

    private List<String> getRole(UserDetailsImpl userDetails) {
        String role = "";
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            role = authority.getAuthority();
        }
        return Collections.singletonList(role);
    }

    @Override
    public UserDTO getByToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> role = getRole(userDetails);
        return new UserDTO(userDetails, role);
    }

    @Override
    public AppUser getAppUserByToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return appUserRepository.findByNik(userDetails.getNik()).get();
    }
}
