package com.audax.cadastro.dto.form;

import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.audax.cadastro.dto.UsersDTO;
import com.audax.cadastro.dto.UsersPostDTO;
import com.audax.cadastro.model.Users;

public class ArticleForm {
	private String title;
	private String resume;
	private String text;
	private JSONObject User;

	

	public ArticleForm(String title, String resume, String text, JSONObject user) {
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

	public JSONObject getUser() {
		return User;
	}

	public void setUser(JSONObject user) {
		User = user;
	}


}
