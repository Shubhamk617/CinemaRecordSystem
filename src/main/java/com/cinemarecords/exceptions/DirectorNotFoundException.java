package com.cinemarecords.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DirectorNotFoundException extends RuntimeException {

	public DirectorNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirectorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DirectorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DirectorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DirectorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
