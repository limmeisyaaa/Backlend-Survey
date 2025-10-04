package id.com.service.mh.repository;

import id.com.service.mh.entity.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativesRepository extends JpaRepository<Relatives, String>, JpaSpecificationExecutor<Relatives> {
}
