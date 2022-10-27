package com.audax.cadastro.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.audax.cadastro.model.Articles;

public class ArticlesDTO {
	private String uuid;
	private String title;
	private String resume;
	private String text;
	private String slug;
	private LocalDateTime registeredAt;
	private UsersDTO user;

	public ArticlesDTO(String uuid, String title, String resume, String text,
			String slug, LocalDateTime registeredAt, UsersDTO user) {
		this.uuid = uuid;
		this.title = title;
		this.resume = resume;
		this.text = text;
		this.slug = slug;
		this.registeredAt = registeredAt;
		this.user = user;
	}

	public ArticlesDTO(Articles articles) {
		this.uuid = articles.getUuid();
		this.title = articles.getTitle();
		this.resume = articles.getResume();
		this.text = articles.getText();
		this.slug = articles.getSlug();
		this.registeredAt = articles.getRegisteredAt();
		this.user = new UsersDTO(articles.getUser());
	}

	public ArticlesDTO() {

	}

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	public UsersDTO getUser() {
		return user;
	}

	public void setUser(UsersDTO user) {
		this.user = user;
	}

	public static List<ArticlesDTO> toArticlesDTO(List<Articles> lista) {
		return lista.stream().map(ArticlesDTO::new).collect(Collectors.toList());
	}

}
