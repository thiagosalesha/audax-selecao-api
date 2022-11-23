package com.selecaoEstagio.cadastro.dto.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.selecaoEstagio.cadastro.dto.UsersDTO;
import com.selecaoEstagio.cadastro.model.Articles;
import com.selecaoEstagio.cadastro.model.Users;
import com.selecaoEstagio.cadastro.repository.ArticlesRepository;

public class ArticleForm {
	@NotEmpty (message = "O título não pode ser vazio")
	@NotNull (message = "O título não pode ser nulo")
	@Length (min = 30, max = 70)
	private String title;
	
	@NotEmpty (message = "O resumo não pode ser vazio")
	@NotNull (message = "O resumo não pode ser nulo")
	@Length (min = 50, max = 100)
	private String resume;
	
	@NotEmpty (message = "O texto não pode ser vazio")
	@NotNull (message = "O texto não pode ser nulo")
	@Length (min = 200)
	private String text;
	
	@JsonProperty("User")
	private UsersDTO User;

	

	public ArticleForm(String title, String resume, String text, UsersDTO user) {
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

	public UsersDTO getUser() {
		return User;
	}

	public void setUser(UsersDTO user) {
		User = user;
	}

	public Articles atualizar(String uuid, ArticlesRepository articlesRepository) {
		Optional<Articles> article = articlesRepository.findByUuid(uuid);
		article.get().setTitle(this.title);
		article.get().setText(this.text);
		article.get().setResume(this.resume);
		return article.get();
	}


}
