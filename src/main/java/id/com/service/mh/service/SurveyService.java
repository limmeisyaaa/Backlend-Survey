package id.com.service.mh.service;

import id.com.service.mh.entity.Survey;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    Survey submitSurvey(Survey survey);
    Survey updateSurvey(Survey survey);
    void deleteSurveyByTrxId(String id);
    List<Survey> readAllSurvey();
    Survey readSurveyById(String id);
    Optional<Survey> getSurveyByTrxId(String trxId);
}
