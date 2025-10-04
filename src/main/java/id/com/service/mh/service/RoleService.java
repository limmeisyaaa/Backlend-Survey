package id.com.service.mh.service;

import id.com.service.mh.entity.shared.Role;
import id.com.service.mh.enums.ERole;

public interface RoleService {
    Role getOrSaveRole(ERole role);
}