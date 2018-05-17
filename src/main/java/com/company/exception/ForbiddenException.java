package com.company.exception;

import com.company.payload.GenericResponse;

public class ForbiddenException extends DomainException {

	private static final long serialVersionUID = -3868512343716957932L;

	public ForbiddenException() {
		super(new GenericResponse<>());
	}

	public ForbiddenException(String message) {
		super(message, new GenericResponse<>());
	}

	public ForbiddenException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public ForbiddenException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}
}
