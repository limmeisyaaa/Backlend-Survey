package id.com.service.mh.repository;

import id.com.service.mh.entity.Survey;
import id.com.service.mh.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, String>, JpaSpecificationExecutor<Survey> {
    Optional<Survey> findSurveyByTransaction(Transaction transaction);
}
