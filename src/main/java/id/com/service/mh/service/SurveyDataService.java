package id.com.service.mh.service;

import id.com.service.mh.entity.SurveyData;

import java.util.List;

public interface SurveyDataService {
    SurveyData createSurveyData(SurveyData surveyData);
    List<SurveyData> readAllSurveyData();
    SurveyData readSurveyDataById(String id);
    SurveyData updateSurveyData(SurveyData surveyData);
}
