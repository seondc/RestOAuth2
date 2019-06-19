package com.icarus.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestOAuth2ExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value= {Exception.class})
	protected ResponseEntity<Object> handleException(Exception ex) {
		RestApiError restApiError = new RestApiError();
		restApiError.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		restApiError.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(restApiError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
