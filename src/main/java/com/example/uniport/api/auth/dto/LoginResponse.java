package com.example.uniport.api.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
	private AuthUserDto user;
	private TokensDto tokens;
}

