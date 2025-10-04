package id.com.service.mh.dto;

public class CustomerSearchDTO {
    private String searchByNik;
    private String searchByFullName;

    public CustomerSearchDTO() {
    }

    public String getSearchByNik() {
        return searchByNik;
    }

    public void setSearchByNik(String searchByNik) {
        this.searchByNik = searchByNik;
    }

    public String getSearchByFullName() {
        return searchByFullName;
    }

    public void setSearchByFullName(String searchByFullName) {
        this.searchByFullName = searchByFullName;
    }
}
