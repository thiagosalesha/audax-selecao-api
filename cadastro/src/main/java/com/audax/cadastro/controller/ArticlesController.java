package com.audax.cadastro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.audax.cadastro.dto.ArticlesDTO;
import com.audax.cadastro.dto.form.ArticleForm;

@RestController
@RequestMapping("article")
public class ArticlesController {
	
	@PostMapping
	public ResponseEntity<ArticlesDTO> register(@RequestBody ArticleForm articleForm) {
		System.out.println(articleForm.getTitle()); 
		System.out.println(articleForm.getUser().getUuid());
		
		
		return null;
	}
}
