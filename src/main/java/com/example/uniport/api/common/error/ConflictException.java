package com.example.uniport.api.common.error;

public class ConflictException extends ApiException {
	public ConflictException() {
		super(ErrorCode.CONFLICT);
	}

	public ConflictException(String message) {
		super(ErrorCode.CONFLICT, message);
	}
}

