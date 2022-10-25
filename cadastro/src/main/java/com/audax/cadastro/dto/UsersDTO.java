package com.audax.cadastro.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.audax.cadastro.model.Users;

public class UsersDTO {

	private String uuid;
	private String username;
	private LocalDate registeredAt;

	public UsersDTO(Users users) {
		this.uuid = users.getUuid();
		this.username = users.getUsername();
		this.registeredAt = users.getRegisteredAt();
	}

	public UsersDTO(String uuid, String username, LocalDate registeredAt) {
		this.uuid = uuid;
		this.username = username;
		this.registeredAt = registeredAt;
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

	public LocalDate getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDate registeredAt) {
		this.registeredAt = registeredAt;
	}
	
	public static List<UsersDTO> toUsers(List<Users> listUsers) {
		return listUsers.stream().map(UsersDTO::new).collect(Collectors.toList());
	}

}
