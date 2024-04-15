package com.backend.backend.controller;

import com.backend.backend.model.User;
import com.backend.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLoginRequest loginRequest) {
        try {
            User authenticatedUser = authService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
            if (authenticatedUser != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(authenticatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to authenticate user");
        }
    }

    static class UserLoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
