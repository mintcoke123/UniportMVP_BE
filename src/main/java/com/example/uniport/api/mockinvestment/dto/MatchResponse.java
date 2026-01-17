package com.example.uniport.api.mockinvestment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MatchResponse {
	private String groupId;
	private boolean matched;
}

