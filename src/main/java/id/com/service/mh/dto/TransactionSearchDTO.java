package id.com.service.mh.dto;

import id.com.service.mh.entity.Transaction;
import id.com.service.mh.enums.ELoanStatus;

import java.util.Date;

public class TransactionSearchDTO {
    private CustomerDTO customer;
    private String nik;
    private String fullName;
    private String trxId;
    private Date trxDate;
    private Boolean isSurvey;
    private ELoanStatus trxStatus;
    private Boolean isDelete;

    public TransactionSearchDTO() {
    }

    public TransactionSearchDTO(Transaction transaction) {
        this.customer = new CustomerDTO(transaction.getCustomerId());
        this.nik = transaction.getCustomerId().getNik();
        this.fullName = transaction.getCustomerId().getFullName();
        this.trxId = transaction.getTrxId();
        this.trxDate = transaction.getTrxDate();
        this.isSurvey = transaction.getIsSurvey();
        this.trxStatus = transaction.getTrxStatus();
        this.isDelete = transaction.getIsDelete();
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customerId) {
        this.customer = customerId;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public Boolean getSurvey() {
        return isSurvey;
    }

    public void setSurvey(Boolean survey) {
        isSurvey = survey;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public ELoanStatus getTrxStatus() {
        return trxStatus;
    }

    public void setTrxStatus(ELoanStatus trxStatus) {
        this.trxStatus = trxStatus;
    }
}
