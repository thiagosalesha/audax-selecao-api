package com.audax.cadastro.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.audax.cadastro.model.Users;

public class UsersPostDTO {

	private String uuid;
	private String username;

	public UsersPostDTO(Users users) {
		this.uuid = users.getUuid();
		this.username = users.getUsername();
	}

	public UsersPostDTO(String uuid, String username) {
		this.uuid = uuid;
		this.username = username;
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


	
	public static List<UsersPostDTO> toUsers(List<Users> listUsers) {
		return listUsers.stream().map(UsersPostDTO::new).collect(Collectors.toList());
	}

}
