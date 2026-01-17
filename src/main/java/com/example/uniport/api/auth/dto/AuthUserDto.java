package com.example.uniport.api.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUserDto {
	private String id;
	private String name;
	private String email;
	private int points;
}

