package com.audax.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.audax.cadastro.dto.ArticlesDTO;
import com.audax.cadastro.dto.UsersDTO;
import com.audax.cadastro.dto.form.ArticleForm;
import com.audax.cadastro.dto.form.UsersForm;
import com.audax.cadastro.model.Articles;
import com.audax.cadastro.model.Users;
import com.audax.cadastro.repository.ArticlesRepository;
import com.audax.cadastro.repository.UsersRepository;

@RestController
@RequestMapping("article")
public class ArticlesController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	@PostMapping //checado
	public ResponseEntity<ArticlesDTO> register(@RequestBody @Valid ArticleForm articleForm) { 
		Optional<Users> usersOptional = usersRepository.findByUuid(articleForm.getUser().getUuid());
		Users users = new Users();
		if (usersOptional.isPresent()) {
			users = usersOptional.get();
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe");
		}
		
		Optional<Articles> searchTitle = articlesRepository.findByTitle(articleForm.getTitle());
		if (searchTitle.isPresent() && articleForm.getTitle().equals(searchTitle.get().getTitle())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título já cadastrado");
		}
		
		Articles articles = new Articles(users, users.getUuid(), articleForm.getTitle(), 
				articleForm.getResume(), articleForm.getText());
		
		articlesRepository.save(articles);
		
		return new ResponseEntity<ArticlesDTO>(new ArticlesDTO(articles), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<ArticlesDTO>> list() {

		List<Articles> lista = articlesRepository.findAll();
		return ResponseEntity.ok(ArticlesDTO.toArticlesDTO(lista));
	}
	
	
	@GetMapping("/{uuid}")
	public ResponseEntity<ArticlesDTO> list(@PathVariable String uuid) {
		Optional<Articles> optArticles = articlesRepository.findByUuid(uuid);
		if(!optArticles.isEmpty()) {
			return ResponseEntity.ok(new ArticlesDTO(optArticles.get()));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe");
		}
	}
	
	@PutMapping("/{uuid}")
	@Transactional
	public ResponseEntity<ArticlesDTO> update(@PathVariable String uuid, @RequestBody @Valid ArticleForm articleForm) {
		Optional<Articles> findByUuid = articlesRepository.findByUuid(uuid);
		if (findByUuid.isPresent()) {
			Articles articleAtual = articleForm.atualizar(uuid, articlesRepository);
			return ResponseEntity.ok(new ArticlesDTO(articleAtual));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe");
		}
	}
	
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		Optional<Articles> articleDeleter = articlesRepository.findByUuid(uuid);
		if (articleDeleter.isPresent()) {
			articlesRepository.delete(articleDeleter.get());	
			return new ResponseEntity<>("Deletado com sucess", HttpStatus.NO_CONTENT);	
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe");
		}
	}

	
}
