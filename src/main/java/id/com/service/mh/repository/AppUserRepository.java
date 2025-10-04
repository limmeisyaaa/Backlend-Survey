package id.com.service.mh.repository;


import id.com.service.mh.entity.shared.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByNik(String nik);
    Optional<AppUser> findByUserId(String userId);
}
