package id.com.service.mh.controller;

import id.com.service.mh.constant.ApiUrlConstant;
import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.dto.LoginDTO;
import id.com.service.mh.dto.UserDTO;
import id.com.service.mh.entity.shared.AppUser;
import id.com.service.mh.service.AuthService;
import id.com.service.mh.utils.Response;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.AUTH)
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-customer")
    public ResponseEntity<Response<?>> registerCustomer(@RequestBody AppUser user) {
        UserDTO register = authService.registerCustomer(user);
        String message = String.format(ResponseMessage.REGISTER, ResponseMessage.CUSTOMER);
        Response<?> response = new Response<>(message, register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/register-staff")
    public ResponseEntity<Response<?>> registerStaff(@RequestBody AppUser user) {
        UserDTO register = authService.registerStaff(user);
        String message = String.format(ResponseMessage.REGISTER, ResponseMessage.STAFF);
        Response<?> response = new Response<>(message, register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/register-supervisor")
    public ResponseEntity<?> registerSupervisor(@RequestBody AppUser user) {
        UserDTO register = authService.registerSupervisor(user);
        String message = String.format(ResponseMessage.REGISTER, ResponseMessage.SUPERVISOR);
        Response<?> response = new Response<>(message, register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/register-manager")
    public ResponseEntity<?> registerManager(@RequestBody AppUser user) {
        UserDTO register = authService.registerManager(user);
        String message = String.format(ResponseMessage.REGISTER, ResponseMessage.MANAGER);
        Response<?> response = new Response<>(message, register);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AppUser user) {
        LoginDTO login = authService.login(user);
        Response<?> response = new Response<>(
                "Successfully login",
                login
        );
        return ResponseEntity.ok(response);
    }


    @GetMapping("/users/{nik}")
    public ResponseEntity<?> getUserByNik (@PathVariable String nik) {
        UserDTO userDTO = authService.readUserByNik(nik);
        Response<?> response = new Response<>(
                "Successfully get user by NIK",
                userDTO
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/users-id/{userId}")
    public ResponseEntity<?> getUserByUserId (@PathVariable String userId) {
        UserDTO userDTO = authService.readUserByUserId(userId);
        Response<?> response = new Response<>(
                "Successfully get user by user id",
                userDTO
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @SecurityRequirement(name = "Authorization")
    @GetMapping("users/me")
    public ResponseEntity<Response<?>> getUserByToken(Authentication authentication) {
        UserDTO userDTO = authService.getByToken(authentication);

        Response<?> response = new Response<>(
                "Successfully get user",
                userDTO
        );
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}