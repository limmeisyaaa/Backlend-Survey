package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relatives_data")
public class Relatives {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String relativesId;
    private String relativesName;
    private String relativesRelation;
    private String relativesPhoneNumber;
    private String relativesCellNumber;
    private String relativesAddress;
    private String relativesRt;
    private String relativesRw;
    private String relativesWard;
    private String relativesDistrict;
    private String relativesCity;
    private String relativesProvince;

    public Relatives() {
    }

    public Relatives(String relativesId) {
        this.relativesId = relativesId;
    }

    public String getRelativesId() {
        return relativesId;
    }

    public void setRelativesId(String relativesId) {
        this.relativesId = relativesId;
    }

    public String getRelativesName() {
        return relativesName;
    }

    public void setRelativesName(String relativesName) {
        this.relativesName = relativesName;
    }

    public String getRelativesRelation() {
        return relativesRelation;
    }

    public void setRelativesRelation(String relativesRelation) {
        this.relativesRelation = relativesRelation;
    }

    public String getRelativesPhoneNumber() {
        return relativesPhoneNumber;
    }

    public void setRelativesPhoneNumber(String relativesPhoneNumber) {
        this.relativesPhoneNumber = relativesPhoneNumber;
    }

    public String getRelativesCellNumber() {
        return relativesCellNumber;
    }

    public void setRelativesCellNumber(String relativesCellNumber) {
        this.relativesCellNumber = relativesCellNumber;
    }

    public String getRelativesAddress() {
        return relativesAddress;
    }

    public void setRelativesAddress(String relativesAddress) {
        this.relativesAddress = relativesAddress;
    }

    public String getRelativesRt() {
        return relativesRt;
    }

    public void setRelativesRt(String relativesRt) {
        this.relativesRt = relativesRt;
    }

    public String getRelativesRw() {
        return relativesRw;
    }

    public void setRelativesRw(String relativesRw) {
        this.relativesRw = relativesRw;
    }

    public String getRelativesWard() {
        return relativesWard;
    }

    public void setRelativesWard(String relativesWard) {
        this.relativesWard = relativesWard;
    }

    public String getRelativesDistrict() {
        return relativesDistrict;
    }

    public void setRelativesDistrict(String relativesDistrict) {
        this.relativesDistrict = relativesDistrict;
    }

    public String getRelativesCity() {
        return relativesCity;
    }

    public void setRelativesCity(String relativesCity) {
        this.relativesCity = relativesCity;
    }

    public String getRelativesProvince() {
        return relativesProvince;
    }

    public void setRelativesProvince(String relativesProvince) {
        this.relativesProvince = relativesProvince;
    }
}
