package com.selecaoEstagio.cadastro.dto.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.selecaoEstagio.cadastro.model.Users;
import com.selecaoEstagio.cadastro.repository.UsersRepository;

public class UsersForm {
	
	@NotNull (message = "O nome do usuário não pode ser nulo!") 
	@NotEmpty (message = "O nome do usuário não pode estar vazio!")
	@Length(min = 3, max = 150, message = "O nome do usário deve conter no mínimo 3 até 150 caracteres!")
	private String username;
	
	@NotNull (message = "A senha do usuário não pode ser nulo!") 
	@NotEmpty (message = "A senha do usuário não pode estar vazia!")
	@Length(min = 8, message = "A senha do usário deve conter no mínimo 8 caracteres!") 
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
