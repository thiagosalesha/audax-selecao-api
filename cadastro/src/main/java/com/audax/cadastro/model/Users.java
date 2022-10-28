package com.audax.cadastro.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.audax.cadastro.dto.form.UsersForm;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String username;
	private String password;
	private ZonedDateTime registeredAt;

	public Users() {
	}

	public Users(UsersForm usersForm) {
		
		this.uuid = UUID.randomUUID().toString();
		this.username = usersForm.getUsername();
		this.password =  new BCryptPasswordEncoder().encode(usersForm.getPassword());
		LocalDateTime ldt = LocalDateTime.now();
		this.registeredAt = ZonedDateTime.of(ldt, ZoneId.of("America/Sao_Paulo"));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ZonedDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(ZonedDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

}
