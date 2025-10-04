package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_survey_customer")
public class SurveyData {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String surveyDataId;
    private String mothersMaidenName;
    private String latestEducationalLevel;
    private Integer dependents;
    private String email;
    private String bankName;
    private String accountName;
    private String accountNumber;

    public SurveyData() {
    }

    public SurveyData(String surveyDataId, String mothersMaidenName, String latestEducationalLevel, Integer dependents, String email, String bankName, String accountName, String accountNumber) {
        this.surveyDataId = surveyDataId;
        this.mothersMaidenName = mothersMaidenName;
        this.latestEducationalLevel = latestEducationalLevel;
        this.dependents = dependents;
        this.email = email;
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public SurveyData(String surveyDataId) {
        this.surveyDataId = surveyDataId;
    }

    public String getSurveyDataId() {
        return surveyDataId;
    }

    public void setSurveyDataId(String surveyDataId) {
        this.surveyDataId = surveyDataId;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public String getLatestEducationalLevel() {
        return latestEducationalLevel;
    }

    public void setLatestEducationalLevel(String latestEducationalLevel) {
        this.latestEducationalLevel = latestEducationalLevel;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
