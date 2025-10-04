package id.com.service.mh.service.impl;

import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserServiceImpl implements UserDetailsService {

    private  final AppUserRepository appUserRepository;

    @Autowired
    public CustomUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepository.findByNik(username);
        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserDetailsImpl(appUser.get());
    }
}
