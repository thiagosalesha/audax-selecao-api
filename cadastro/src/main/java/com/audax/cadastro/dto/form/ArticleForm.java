package com.audax.cadastro.dto.form;

import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.audax.cadastro.dto.UsersDTO;
import com.audax.cadastro.dto.UsersPostDTO;
import com.audax.cadastro.model.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleForm {
	private String title;
	private String resume;
	private String text;
	
	@JsonProperty("User")
	private UsersPostDTO User;

	

	public ArticleForm(String title, String resume, String text, UsersPostDTO user) {
		this.title = title;
		this.resume = resume;
		this.text = text;
		this.User = user;
	}

	public ArticleForm() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UsersPostDTO getUser() {
		return User;
	}

	public void setUser(UsersPostDTO user) {
		User = user;
	}


}
