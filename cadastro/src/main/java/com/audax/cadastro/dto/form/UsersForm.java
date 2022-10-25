package com.audax.cadastro.dto.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.audax.cadastro.model.Users;
import com.audax.cadastro.repository.UsersRepository;

public class UsersForm {
	
	@NotNull @NotEmpty @Length(min = 3, max = 150)
	private String username;
	
	@NotNull @NotEmpty @Length(min = 8) 
	private String password;

	public UsersForm(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UsersForm() {
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

	public Users atualizar(String uuid, UsersRepository usersRepository) {
		Optional<Users> user = usersRepository.findByUuid(uuid);
		user.get().setPassword(new BCryptPasswordEncoder().encode(this.password));
		user.get().setUsername(this.username);
		return user.get();
	}

}
