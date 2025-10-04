package id.com.service.mh.dto;

import id.com.service.mh.service.impl.UserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class LoginDTO {

    private String nik;
    private List<String> role;
    private String token;

    public LoginDTO() {
    }

    public LoginDTO(UserDetailsImpl user, String token) {
        this.nik = user.getUsername();
        this.role = user.getAuthorities().stream().map(
                GrantedAuthority::getAuthority
        ).collect(Collectors.toList());
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}