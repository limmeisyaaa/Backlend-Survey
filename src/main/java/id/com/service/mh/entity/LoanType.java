package id.com.service.mh.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "loan_type")
@Getter
@Setter
@NoArgsConstructor
public class LoanType {
    @Column(name = "loan_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String loanId;

    @Column(name = "loan_limit")
    private Double loanLimit;

}
