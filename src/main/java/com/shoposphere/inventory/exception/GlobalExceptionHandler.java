package com.shoposphere.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shoposphere.exception.ProductNotAvailableException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotAvailableException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFound(ProductNotAvailableException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBadRequest(IllegalArgumentException ex) {
		return ex.getMessage();
	}
}
