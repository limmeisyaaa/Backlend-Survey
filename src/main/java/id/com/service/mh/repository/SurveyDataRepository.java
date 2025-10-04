package id.com.service.mh.repository;

import id.com.service.mh.entity.SurveyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDataRepository extends JpaRepository<SurveyData, String>, JpaSpecificationExecutor<SurveyData> {
}
