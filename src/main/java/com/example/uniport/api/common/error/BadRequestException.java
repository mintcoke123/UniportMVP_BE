package com.example.uniport.api.common.error;

public class BadRequestException extends ApiException {
	public BadRequestException() {
		super(ErrorCode.BAD_REQUEST);
	}

	public BadRequestException(String message) {
		super(ErrorCode.BAD_REQUEST, message);
	}
}

