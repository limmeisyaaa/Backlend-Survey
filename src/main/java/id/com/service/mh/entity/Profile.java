package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_profile")
public class Profile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String profileId;
    private Boolean breadwinner;
    private Boolean literacyAbility;
    private Boolean transportationOwner;
    private Boolean insuranceOwner;
    private Boolean internetAccess;

    public Profile() {
    }

    public Profile(String profileId, Boolean breadwinner, Boolean literacyAbility, Boolean transportationOwner, Boolean insuranceOwner, Boolean internetAccess) {
        this.profileId = profileId;
        this.breadwinner = breadwinner;
        this.literacyAbility = literacyAbility;
        this.transportationOwner = transportationOwner;
        this.insuranceOwner = insuranceOwner;
        this.internetAccess = internetAccess;
    }

    public Profile(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getBreadwinner() {
        return breadwinner;
    }

    public void setBreadwinner(Boolean breadwinner) {
        this.breadwinner = breadwinner;
    }

    public Boolean getLiteracyAbility() {
        return literacyAbility;
    }

    public void setLiteracyAbility(Boolean literacyAbility) {
        this.literacyAbility = literacyAbility;
    }

    public Boolean getTransportationOwner() {
        return transportationOwner;
    }

    public void setTransportationOwner(Boolean transportationOwner) {
        this.transportationOwner = transportationOwner;
    }

    public Boolean getInsuranceOwner() {
        return insuranceOwner;
    }

    public void setInsuranceOwner(Boolean insuranceOwner) {
        this.insuranceOwner = insuranceOwner;
    }

    public Boolean getInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(Boolean internetAccess) {
        this.internetAccess = internetAccess;
    }
}
