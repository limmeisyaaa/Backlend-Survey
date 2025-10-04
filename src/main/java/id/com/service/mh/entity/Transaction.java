package id.com.service.mh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.com.service.mh.enums.ELoanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Column(name = "trx_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String trxId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date trxDate;

    @Column(name = "nominal_credit")
    private Double nominalCredit;

    @Column(name = "trx_status")
    @Enumerated(EnumType.STRING)
    private ELoanStatus trxStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "interest_id")
    private Interest interestId;

    private String description;

    private Boolean isDelete = false;

    private Boolean isSurvey= false;

    @OneToOne
    @JoinColumn(name = "guarantee_id")
    private Guarantee guaranteeId;

    @OneToOne
    @JoinColumn(name = "customer_income_id")
    private CustomerIncome customerIncomeId;

    private String firstApprovedBy;
    private Date firstApprovedAt;
    private String secondApprovedBy;
    private Date secondApprovedAt;
    private String rejectedBy;
    private Date rejectedAt;
    private String reason;

    public Transaction(String trxId) {
        this.trxId = trxId;
    }
}