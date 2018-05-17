package com.company.exception;

import com.company.payload.GenericResponse;

public class InternalServerErrorException extends DomainException {

	private static final long serialVersionUID = -3868512343716957932L;

	public InternalServerErrorException() {
		super(new GenericResponse<>());
	}

	public InternalServerErrorException(String message) {
		super(message, new GenericResponse<>());
	}

	public InternalServerErrorException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public InternalServerErrorException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}
}
