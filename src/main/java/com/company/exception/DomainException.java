package com.company.exception;

import com.company.payload.GenericResponse;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = -6483840969328888766L;

	private GenericResponse<?> genericResponse = new GenericResponse<>();

	public DomainException(GenericResponse<?> genericResponse) {
		this.genericResponse = genericResponse;
	}

	public DomainException(String message) {
		super(message);
	}

	public DomainException(String message, GenericResponse<?> genericResponse) {
		super(message);
		this.genericResponse = genericResponse;
	}

	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainException(String message, Throwable cause, GenericResponse<?> genericResponse) {
		super(message, cause);
		this.genericResponse = genericResponse;
	}

	public DomainException(Throwable cause) {
		super(cause);
	}

	public GenericResponse<?> getGenericResponse() {
		return genericResponse;
	}

	public void setGenericResponse(GenericResponse<?> genericResponse) {
		this.genericResponse = genericResponse;
	}
}
