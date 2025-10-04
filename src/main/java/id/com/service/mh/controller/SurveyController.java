package id.com.service.mh.controller;

import id.com.service.mh.constant.ApiUrlConstant;
import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.Survey;
import id.com.service.mh.service.SurveyService;
import id.com.service.mh.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiUrlConstant.SURVEY)
public class SurveyController {
    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_STAFF', 'ROLE_CUSTOMER')")
    public ResponseEntity<Response<Survey>> submitSurvey(@RequestBody Survey survey){
        String message = String.format(ResponseMessage.CREATE, ResponseMessage.SURVEY);
        Response<Survey> response = new Response<>(message, surveyService.submitSurvey(survey));
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_STAFF', 'ROLE_CUSTOMER')")
    public ResponseEntity<Response<Survey>> updateSurvey(@RequestBody Survey survey) {
        String message = String.format(ResponseMessage.UPDATE, ResponseMessage.SURVEY);
        Response<Survey> response = new Response<>(message, surveyService.updateSurvey(survey));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<Survey>>> readAllSurvey(){
        String message = String.format(ResponseMessage.READ, ResponseMessage.SURVEY);
        Response<List<Survey>> response = new Response<>(message, surveyService.readAllSurvey());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Response<Survey>> readSurveyById(@PathVariable String id){
        String message = String.format(ResponseMessage.READ, ResponseMessage.SURVEY);
        Response<Survey> response = new Response<>(message, surveyService.readSurveyById(id));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/id/{trxId}")
    public ResponseEntity<Response<Optional<Survey>>> readSurveyByTrxId(@PathVariable String trxId){
        String message = String.format(ResponseMessage.READ, ResponseMessage.SURVEY);
        Response<Optional<Survey>> response = new Response<>(message, surveyService.getSurveyByTrxId(trxId));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/id/{trxId}")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<Response<Survey>> deleteSurveyByTrxId(@PathVariable String trxId){
        String message = String.format(ResponseMessage.DELETE, ResponseMessage.SURVEY);
        Response<Survey> response = new Response<>();
        response.setMessage(message);
        surveyService.deleteSurveyByTrxId(trxId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
