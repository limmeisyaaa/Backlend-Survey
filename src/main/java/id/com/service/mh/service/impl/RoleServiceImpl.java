package id.com.service.mh.service.impl;

import id.com.service.mh.entity.shared.Role;
import id.com.service.mh.enums.ERole;
import id.com.service.mh.repository.AppUserRepository;
import id.com.service.mh.repository.RoleRepository;
import id.com.service.mh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public Role getOrSaveRole(ERole role) {
        return roleRepository.findByRoleName(role).orElseGet(
                () -> roleRepository.save(new Role(null, role))
        );
    }
}