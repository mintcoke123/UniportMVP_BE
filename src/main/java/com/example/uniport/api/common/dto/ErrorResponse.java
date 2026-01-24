package com.example.uniport.api.common.dto;

import java.util.Map;

import com.example.uniport.api.common.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private Error error;

	@Getter
	@AllArgsConstructor
	public static class Error {
		private ErrorCode code;
		private String message;
		private Map<String, Object> details;
	}
}

