package id.com.service.mh.dto;

import id.com.service.mh.entity.Customer;
import id.com.service.mh.entity.Occupation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDTO {
    private String customerId;
    private String nik;
    private String email;
    private String fullName;
    private String birthPlace;
    private Date birthDate;
    private String gender;
    private String maritalStatus;
    private String religion;
    private String phoneNumber;
    private String address;
    private String rt;
    private String rw;
    private String ward;
    private String district;
    private String city;
    private String province;
    private String postalCode;
    private String occupationType;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.nik = customer.getNik();
        this.email = customer.getEmail();
        this.fullName = customer.getFullName();
        this.birthPlace = customer.getBirthPlace();
        this.birthDate = customer.getBirthDate();
        this.gender = customer.getGender();
        this.maritalStatus = customer.getMaritalStatus();
        this.religion = customer.getReligion();
        this.phoneNumber = customer.getPhoneNumber();
        this.address = customer.getAddress();
        this.rt = customer.getRt();
        this.rw = customer.getRw();
        this.ward = customer.getWard();
        this.district = customer.getDistrict();
        this.city = customer.getCity();
        this.province = customer.getProvince();
        this.postalCode = customer.getPostalCode();
        this.occupationType = customer.getOccupationType().getOccupation();
    }

    public static Customer createCustomer(String[] data) {
        Customer customer = new Customer();
        customer.setNik(data[0]);
        customer.setEmail(data[1]);
        customer.setFullName(data[2]);
        customer.setBirthPlace(data[3]);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // adjust format as needed
            customer.setBirthDate(dateFormat.parse(data[4]));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + data[4]);
        }

        customer.setGender(data[5]);
        customer.setMaritalStatus(data[6]);
        customer.setReligion(data[7]);
        customer.setPhoneNumber(data[8]);
        customer.setAddress(data[9]);
        customer.setRt(data[10]);
        customer.setRw(data[11]);
        customer.setWard(data[12]);
        customer.setDistrict(data[13]);
        customer.setCity(data[14]);
        customer.setProvince(data[15]);
        customer.setPostalCode(data[16]);
        return customer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }
}