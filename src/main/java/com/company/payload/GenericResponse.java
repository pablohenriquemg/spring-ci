package com.company.payload;

import java.io.Serializable;

public class GenericResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7768814513491892391L;

	private transient T resultData;
	private MessageResponse error;

	public GenericResponse() {
		super();
	}

	public GenericResponse(T resultData, MessageResponse error) {
		super();
		this.resultData = resultData;
		this.error = error;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public MessageResponse getError() {
		return error;
	}

	public void setError(MessageResponse error) {
		this.error = error;
	}

}
