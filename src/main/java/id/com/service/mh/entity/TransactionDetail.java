package id.com.service.mh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "transaction_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String transactionDetailId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date installmentDate;
    private Double installmentTotal;

    @ManyToOne
    @JoinColumn(name = "trx_id")
    private Transaction trxId;

    @ManyToOne
    @JoinColumn(name = "disbursement_id")
    private Disbursement disbursementId;

    public TransactionDetail() {
    }


    public String getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(String transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    public Date getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Date installmentDate) {
        this.installmentDate = installmentDate;
    }

    public Double getInstallmentTotal() {
        return installmentTotal;
    }

    public void setInstallmentTotal(Double installmentTotal) {
        this.installmentTotal = installmentTotal;
    }

    public Transaction getTrxId() {
        return trxId;
    }

    public void setTrxId(Transaction trxId) {
        this.trxId = trxId;
    }

    public Disbursement getDisbursementId() {
        return disbursementId;
    }

    public void setDisbursementId(Disbursement disbursementId) {
        this.disbursementId = disbursementId;
    }
}
