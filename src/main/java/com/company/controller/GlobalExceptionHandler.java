package com.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.company.exception.BadRequestException;
import com.company.exception.DomainException;
import com.company.exception.ForbiddenException;
import com.company.exception.InternalServerErrorException;
import com.company.exception.NotFoundException;
import com.company.payload.GenericResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	protected HttpHeaders headers() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return httpHeaders;
	}

	private void initGenericResponse(DomainException e) {

		GenericResponse<?> response = e.getGenericResponse() != null ? e.getGenericResponse() : new GenericResponse<>();

		if (response.getError() != null && response.getError().getCode() != null) {
			String description = response.getError().getCode();
			if (!description.equals(response.getError().getCode())) {
				response.getError().setDescription(description);
			}
		}

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<GenericResponse<?>> badRequestException(BadRequestException e) {

		initGenericResponse(e);
		logger.error(String.format("Bad request error %s", e.getGenericResponse()));

		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<GenericResponse<?>> illegalArgumentException(Exception e) {

		GenericResponse<?> response = new GenericResponse<>();
		logger.error("Illegal argument error", e);

		return new ResponseEntity<>(response, headers(), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<GenericResponse<?>> forbiddenException(ForbiddenException e) {

		initGenericResponse(e);
		logger.error(String.format("Forbidden error. %s", e.getGenericResponse()));

		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.FORBIDDEN);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<GenericResponse<?>> internalServerErrorException(InternalServerErrorException e) {

		initGenericResponse(e);
		logger.error(String.format("Internal server error. %s", e.getGenericResponse()));

		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<GenericResponse<?>> notFoundException(NotFoundException e) {

		initGenericResponse(e);
		logger.error(String.format("Not found error. %s", e.getGenericResponse()));

		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.NOT_FOUND);
	}
}
