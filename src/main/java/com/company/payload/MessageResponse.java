package com.company.payload;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6406195553191698532L;

	private String code;
	private String description;

	public MessageResponse() {
		super();
	}

	public MessageResponse(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
