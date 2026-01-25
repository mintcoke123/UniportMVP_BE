package com.example.uniport.api.auth.service;

import com.example.uniport.api.auth.dto.LoginRequest;
import com.example.uniport.api.auth.dto.LoginResponse;
import com.example.uniport.api.auth.dto.MeResponse;
import com.example.uniport.api.auth.dto.RefreshResponse;
import com.example.uniport.api.auth.dto.SignupRequest;
import com.example.uniport.api.auth.dto.SignupResponse;

public interface AuthService {
    SignupResponse signup(SignupRequest request);
    LoginResponse login(LoginRequest request);
    void logout();
    RefreshResponse refresh();
    MeResponse me();
}

