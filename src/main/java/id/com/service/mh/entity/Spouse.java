package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "spouse_data")
public class Spouse {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String spouseId;
    private String spouseNik;
    private String spouseName;
    private Date spouseBirthdate;
    private String gender;
    private String spouseBirthplace;
    private String spouseMothersMaidenName;

    public Spouse() {
    }


    public Spouse(String spouseId) {
        this.spouseId = spouseId;
    }

    public String getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(String spouseId) {
        this.spouseId = spouseId;
    }

    public String getSpouseNik() {
        return spouseNik;
    }

    public void setSpouseNik(String spouseNik) {
        this.spouseNik = spouseNik;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public Date getSpouseBirthdate() {
        return spouseBirthdate;
    }

    public void setSpouseBirthdate(Date spouseBirthdate) {
        this.spouseBirthdate = spouseBirthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpouseBirthplace() {
        return spouseBirthplace;
    }

    public void setSpouseBirthplace(String spouseBirthplace) {
        this.spouseBirthplace = spouseBirthplace;
    }

    public String getSpouseMothersMaidenName() {
        return spouseMothersMaidenName;
    }

    public void setSpouseMothersMaidenName(String spouseMothersMaidenName) {
        this.spouseMothersMaidenName = spouseMothersMaidenName;
    }
}
