package com.company.exception;

import com.company.payload.GenericResponse;

public class NotFoundException extends DomainException {

	private static final long serialVersionUID = -4366711916560868377L;

	public NotFoundException() {
		super(new GenericResponse<>());
	}

	public NotFoundException(String message) {
		super(message, new GenericResponse<>());
	}

	public NotFoundException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public NotFoundException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}
}
