package com.mybooking.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidScreenException extends RuntimeException {

	public InvalidScreenException(String exception) {
		super(exception);
	}
}
