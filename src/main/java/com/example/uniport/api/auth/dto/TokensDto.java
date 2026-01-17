package com.example.uniport.api.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokensDto {
	private String accessToken;
	private long expiresIn;
}

