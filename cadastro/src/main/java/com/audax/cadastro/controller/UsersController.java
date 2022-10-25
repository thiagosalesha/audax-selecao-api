package com.audax.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audax.cadastro.dto.UsersDTO;
import com.audax.cadastro.dto.form.UsersForm;
import com.audax.cadastro.model.Users;
import com.audax.cadastro.repository.UsersRepository;

@RestController
@RequestMapping("user")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping
	public List<UsersDTO> lista() {
		List<Users> lista = usersRepository.findAll();
		return UsersDTO.toUsers(lista);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid UsersForm usersForm) {
		Users user = new Users(usersForm);
		if (usersRepository.findByUsername(usersForm.getUsername()) != null) {
			System.out.println("erro");
		} else {
			usersRepository.save(user);

		}
	}

}
