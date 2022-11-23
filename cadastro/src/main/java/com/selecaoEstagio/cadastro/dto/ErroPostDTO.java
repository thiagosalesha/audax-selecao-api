package com.selecaoEstagio.cadastro.dto;

public class ErroPostDTO {

	private String message;
	private String field;



	public ErroPostDTO( String message, String field) {

		this.message = message;
		this.field = field;
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
