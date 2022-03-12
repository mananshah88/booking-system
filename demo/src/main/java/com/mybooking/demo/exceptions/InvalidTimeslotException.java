package com.mybooking.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidTimeslotException extends RuntimeException {

	public InvalidTimeslotException(String exception) {
		super(exception);
	}
}
