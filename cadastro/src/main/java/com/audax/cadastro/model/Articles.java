package com.audax.cadastro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.audax.cadastro.dto.ArticlesDTO;
import com.github.slugify.Slugify;

@Entity
public class Articles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Users user;
	
	private String uuid; 
	private String title;
	private String resume;
	private String text;
	private String slug; 
	private ZonedDateTime registeredAt; 


	public Articles() {
	}

	public Articles(Users user, String uuid, String title, String resume, String text) {
		final Slugify slg = Slugify.builder().build();	
		this.user = user;
		this.uuid = UUID.randomUUID().toString();
		this.title = title;
		this.resume = resume;
		this.text = text;
		this.slug = slg.slugify(title);
		LocalDateTime ldt = LocalDateTime.now();
		this.registeredAt = ZonedDateTime.of(ldt, ZoneId.of("America/Sao_Paulo"));
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
		Slugify slg = Slugify.builder().build();		
		this.title = slg.slugify(title);
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

	public ZonedDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(ZonedDateTime registeredAt) {
		this.registeredAt = registeredAt;
		
	}
	

}
