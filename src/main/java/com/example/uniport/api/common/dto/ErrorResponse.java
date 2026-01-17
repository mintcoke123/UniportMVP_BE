package com.example.uniport.api.common.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private Error error;

	@Getter
	@AllArgsConstructor
	public static class Error {
		private String code;
		private String message;
		private Map<String, Object> details;
	}
}

