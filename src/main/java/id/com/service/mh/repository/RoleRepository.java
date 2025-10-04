package id.com.service.mh.repository;

import id.com.service.mh.entity.shared.Role;
import id.com.service.mh.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleName(ERole roleName);
}
