package com.example.uniport.api.common.error;

public class NotFoundException extends ApiException {
	public NotFoundException() {
		super(ErrorCode.NOT_FOUND);
	}

	public NotFoundException(String message) {
		super(ErrorCode.NOT_FOUND, message);
	}
}

