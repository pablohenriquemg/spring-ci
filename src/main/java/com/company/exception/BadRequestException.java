package com.company.exception;

import com.company.payload.GenericResponse;

public class BadRequestException extends DomainException {

	private static final long serialVersionUID = -3868512343716957932L;

	public BadRequestException() {
		super(new GenericResponse<>());
	}

	public BadRequestException(String message) {
		super(message, new GenericResponse<>());
	}

	public BadRequestException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public BadRequestException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}
}
