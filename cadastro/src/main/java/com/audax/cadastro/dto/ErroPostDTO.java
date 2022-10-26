package com.audax.cadastro.dto;

public class ErroPostDTO {

	private String message;
	private String field;

	public ErroPostDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public ErroPostDTO() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
