package com.example.uniport.api.auth.controller;

import com.example.uniport.api.auth.dto.LoginRequest;
import com.example.uniport.api.auth.dto.LoginResponse;
import com.example.uniport.api.auth.dto.MeResponse;
import com.example.uniport.api.auth.dto.RefreshResponse;
import com.example.uniport.api.auth.dto.SignupRequest;
import com.example.uniport.api.auth.dto.SignupResponse;
import com.example.uniport.api.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        SignupResponse response = authService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<Void> logout() {
        authService.logout();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/auth/refresh")
    public RefreshResponse refresh() {
        return authService.refresh();
    }

    @GetMapping("/auth/me")
    public MeResponse me() {
        return authService.me();
    }
}

