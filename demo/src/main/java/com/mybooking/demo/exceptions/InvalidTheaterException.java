package com.mybooking.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTheaterException extends RuntimeException {

	public InvalidTheaterException(String exception) {
		super(exception);
	}
}
