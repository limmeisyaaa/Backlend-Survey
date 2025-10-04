package id.com.service.mh.entity;

import id.com.service.mh.enums.EInstallmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "installment_type")
@Getter
@Setter
@NoArgsConstructor
public class InstallmentType {

    @Column(name = "installment_type_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String installmentId;

    @Column(name = "installment_type")
    @Enumerated(EnumType.STRING)
    private EInstallmentType installmentType;
}