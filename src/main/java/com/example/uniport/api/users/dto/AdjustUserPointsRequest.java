package com.example.uniport.api.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdjustUserPointsRequest {
	private int delta;
	private String reason;
}

