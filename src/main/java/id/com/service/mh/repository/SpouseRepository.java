package id.com.service.mh.repository;

import id.com.service.mh.entity.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpouseRepository extends JpaRepository<Spouse, String>, JpaSpecificationExecutor<Spouse> {
}
