package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.Survey;
import id.com.service.mh.entity.Transaction;
import id.com.service.mh.repository.SurveyRepository;
import id.com.service.mh.service.*;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    private SurveyRepository surveyRepository;
    private SurveyDataService surveyDataService;
    private SpouseService spouseService;
    private RelativesService relativesService;
    private ProfileService profileService;
    private TransactionService transactionService;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, SurveyDataService surveyDataService, SpouseService spouseService, RelativesService relativesService, ProfileService profileService, TransactionService transactionService) {
        this.surveyRepository = surveyRepository;
        this.surveyDataService = surveyDataService;
        this.spouseService = spouseService;
        this.relativesService = relativesService;
        this.profileService = profileService;
        this.transactionService = transactionService;
    }

    @Override
    @Transactional
    public Survey submitSurvey(Survey survey) {
        surveyDataService.createSurveyData(survey.getSurveyData());
        spouseService.createSpouse(survey.getSpouse());
        relativesService.createRelatives(survey.getRelatives());
        profileService.createProfile(survey.getProfile());
        Survey survey1 = surveyRepository.save(survey);
        Transaction transaction = transactionService.getTrxById(survey1.getTransaction().getTrxId());
        transaction.setIsSurvey(true);
        transactionService.updateStatusSurvey(transaction);
        return survey1;
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        surveyDataService.updateSurveyData(survey.getSurveyData());
        spouseService.updateSpouse(survey.getSpouse());
        relativesService.updateRelatives(survey.getRelatives());
        profileService.updateProfile(survey.getProfile());
        Survey survey1 = surveyRepository.save(survey);
        return survey1;
    }

    @Override
    public void deleteSurveyByTrxId(String trxId) {
        Optional<Survey> survey = getSurveyByTrxId(trxId);
        if (surveyRepository.findById(survey.get().getSurveyId()).isPresent()){
            surveyRepository.deleteById(survey.get().getSurveyId());
            Transaction transaction = transactionService.getTrxById(trxId);
            transaction.setIsSurvey(false);
            transactionService.updateStatusSurvey(transaction);
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.SURVEY, trxId));
        }
    }

    @Override
    public List<Survey> readAllSurvey() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey readSurveyById(String id) {
        if (surveyRepository.findById(id).isPresent()){
            return surveyRepository.findById(id).get();
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.SURVEY, id));
        }
    }

    @Override
    public Optional<Survey> getSurveyByTrxId(String trxId) {
        Transaction transaction = transactionService.getTrxById(trxId);
        return surveyRepository.findSurveyByTransaction(transaction);
    }
}
