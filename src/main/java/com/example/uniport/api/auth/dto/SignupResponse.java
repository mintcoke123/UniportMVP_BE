package com.example.uniport.api.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponse {
	private AuthUserDto user;
	private TokensDto tokens;
}

