package id.com.service.mh.dto;

import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.service.impl.UserDetailsImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private String nik;
    private List<String> role;

    public UserDTO(AppUser user) {
        this.nik = user.getNik();
        this.role = user.getRoles().stream().map(
                        role -> role.getRoleName().name())
                .collect(Collectors.toList());
    }


    public UserDTO(UserDetailsImpl userDetails, List<String> roleUser) {
        this.nik = userDetails.getNik();
        this.role = roleUser;
    }


    public UserDTO() {
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}