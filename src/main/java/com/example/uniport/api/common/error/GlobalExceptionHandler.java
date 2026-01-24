package com.example.uniport.api.common.error;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.uniport.api.common.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
		ErrorCode errorCode = ex.getErrorCode();
		Map<String, Object> details = ex.getDetails();
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			errorCode,
			resolveMessage(ex.getMessage(), errorCode),
			details
		));
		return ResponseEntity.status(errorCode.getHttpStatus()).body(body);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, Object> details = new HashMap<>();
		Map<String, String> fieldErrors = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a, b) -> a));
		details.put("fieldErrors", fieldErrors);
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.VALIDATION_ERROR,
			ErrorCode.VALIDATION_ERROR.getDefaultMessage(),
			details
		));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler({
		HttpMessageNotReadableException.class,
		MissingServletRequestParameterException.class
	})
	public ResponseEntity<ErrorResponse> handleBadRequest(Exception ex) {
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.BAD_REQUEST,
			resolveMessage(ex.getMessage(), ErrorCode.BAD_REQUEST),
			null
		));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.METHOD_NOT_ALLOWED,
			resolveMessage(ex.getMessage(), ErrorCode.METHOD_NOT_ALLOWED),
			null
		));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(body);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleUnsupportedMediaType(HttpMediaTypeNotSupportedException ex) {
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.UNSUPPORTED_MEDIA_TYPE,
			resolveMessage(ex.getMessage(), ErrorCode.UNSUPPORTED_MEDIA_TYPE),
			null
		));
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(body);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NoHandlerFoundException ex) {
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.NOT_FOUND,
			resolveMessage(ex.getMessage(), ErrorCode.NOT_FOUND),
			null
		));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOthers(Exception ex, WebRequest request) {
		ErrorResponse body = new ErrorResponse(new ErrorResponse.Error(
			ErrorCode.INTERNAL_ERROR,
			resolveMessage(ex.getMessage(), ErrorCode.INTERNAL_ERROR),
			null
		));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}

	private String resolveMessage(String message, ErrorCode fallback) {
		if (message == null || message.isBlank()) {
			return fallback.getDefaultMessage();
		}
		return message;
	}
}

