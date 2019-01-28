package com.gslab.talent.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4070184574634372082L;

	public UserNotFoundException(String arg0) {
		super(arg0);
	}
}
