package com.example.uniport.api.common.error;

public class UnauthorizedException extends ApiException {
	public UnauthorizedException() {
		super(ErrorCode.UNAUTHORIZED);
	}

	public UnauthorizedException(String message) {
		super(ErrorCode.UNAUTHORIZED, message);
	}
}

