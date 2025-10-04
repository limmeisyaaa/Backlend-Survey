package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.SurveyData;
import id.com.service.mh.repository.SurveyDataRepository;
import id.com.service.mh.service.SurveyDataService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyDataServiceImpl implements SurveyDataService {

    SurveyDataRepository surveyDataRepository;

    @Autowired
    public SurveyDataServiceImpl(SurveyDataRepository surveyDataRepository) {
        this.surveyDataRepository = surveyDataRepository;
    }

    @Override
    public SurveyData createSurveyData(SurveyData surveyData) {
        return surveyDataRepository.save(surveyData);
    }

    @Override
    public List<SurveyData> readAllSurveyData() {
        return surveyDataRepository.findAll();
    }

    @Override
    public SurveyData readSurveyDataById(String id) {
        if (surveyDataRepository.findById(id).isPresent()){
            return surveyDataRepository.findById(id).get();
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.SURVEYDATA, id));
        }
    }

    @Override
    public SurveyData updateSurveyData(SurveyData surveyData) {
        return surveyDataRepository.save(surveyData);
    }
}
