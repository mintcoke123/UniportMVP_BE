package com.example.uniport.api.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetUserResponse {
	private String id;
	private String name;
	private int points;
	private String createdAt;
}

