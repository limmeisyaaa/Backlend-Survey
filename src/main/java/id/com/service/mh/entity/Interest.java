package id.com.service.mh.entity;

import id.com.service.mh.entity.shared.Time;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "interest")
@Getter
@Setter
@NoArgsConstructor
public class Interest {
    @Column(name = "interest_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String interestId;

    private Double interest;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private LoanType loanId;

    @ManyToOne
    @JoinColumn(name = "installment_type_id")
    private InstallmentType installmentId;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time timeId;
}