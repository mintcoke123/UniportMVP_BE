package com.example.uniport.api.common.error;

public class ForbiddenException extends ApiException {
	public ForbiddenException() {
		super(ErrorCode.FORBIDDEN);
	}

	public ForbiddenException(String message) {
		super(ErrorCode.FORBIDDEN, message);
	}
}

