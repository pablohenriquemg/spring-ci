package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.company.payload.GenericResponse;
import com.company.payload.MessageResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public GenericResponse<?> requestHandlingNoHandlerFound() {
		MessageResponse error = new MessageResponse("not.found", "Not found");
		return new GenericResponse<>(null, error);
	}
}
