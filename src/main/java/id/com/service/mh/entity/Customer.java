package id.com.service.mh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.com.service.mh.entity.shared.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mst_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Column(name = "customer_id")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String customerId;

    @Column(unique = true)
    private String nik;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String gender;

    @Column(name = "marital_stat")
    private String maritalStatus;
    private String religion;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String rt;
    private String rw;
    private String ward;
    private String district;
    private String city;
    private String province;
    @Column(name = "office_location")
    private String officeLocation;
    @Column(name = "postal_code")
    private String postalCode;
    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupationType;
    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private List<SupportingDocument> supportingDocument;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser userId;

    private Boolean isDelete = false;
}