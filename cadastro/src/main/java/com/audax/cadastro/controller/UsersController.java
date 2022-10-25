package com.audax.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<UsersDTO> list() {

		List<Users> lista = usersRepository.findAll();
		return UsersDTO.toUsers(lista);
	}
	
	@GetMapping("/{uuid}")
	public UsersDTO list(@PathVariable String uuid) {
		Users user = usersRepository.findByUuid(uuid);
		return new UsersDTO(user);
	}

	@PostMapping
	public void register(@RequestBody @Valid UsersForm usersForm) {
		Users user = new Users(usersForm);
		if (usersRepository.findByUsername(usersForm.getUsername()) != null) {
			System.out.println("erro");
		} else {
			usersRepository.save(user);
		}
	}
	
	@PutMapping("/{uuid}")
	@Transactional
	public UsersDTO lista(@PathVariable String uuid, @RequestBody @Valid UsersForm usersForm) {
		Users atualizar = usersForm.atualizar(uuid, usersRepository);
		
		System.out.println("Nome usuário: " + usersForm.getUsername());
		System.out.println("Senha usuário: " + usersForm.getPassword());
		return new UsersDTO(atualizar);
	}
	
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable String uuid) {
		Users deletar = usersRepository.findByUuid(uuid);
		usersRepository.delete(deletar);
		return "Deletado com Sucesso";
	}
}
