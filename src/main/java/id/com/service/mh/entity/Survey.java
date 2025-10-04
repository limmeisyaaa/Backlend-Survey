package id.com.service.mh.entity;

import id.com.service.mh.enums.ERole;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "survey")
@SQLDelete(sql = "UPDATE survey SET is_delete = true WHERE survey_id=?")
@Where(clause = "is_delete = false")
public class Survey {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String surveyId;
    @OneToOne
    @JoinColumn(name = "trx_id")
    private Transaction transaction;
    @OneToOne
    @JoinColumn(name = "survey_data_id")
    private SurveyData surveyData;
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @OneToOne
    @JoinColumn(name = "spouse_id")
    private Spouse spouse;
    @OneToOne
    @JoinColumn(name = "relatives_id")
    private Relatives relatives;
    @Enumerated(EnumType.STRING)
    private ERole roleName;
    private Boolean isDelete = Boolean.FALSE;

    public Survey() {
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public SurveyData getSurveyData() {
        return surveyData;
    }

    public void setSurveyData(SurveyData surveyData) {
        this.surveyData = surveyData;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public Relatives getRelatives() {
        return relatives;
    }

    public void setRelatives(Relatives relatives) {
        this.relatives = relatives;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
