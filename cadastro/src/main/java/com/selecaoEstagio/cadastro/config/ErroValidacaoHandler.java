package com.selecaoEstagio.cadastro.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import com.selecaoEstagio.cadastro.dto.ErroNotFoundDTO;
import com.selecaoEstagio.cadastro.dto.ErroPostDTO;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroPostDTO> handle(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<ErroPostDTO> erroDTO = new ArrayList<>();
		fieldErrors.forEach(e -> {
			ErroPostDTO erroFormDTO = new ErroPostDTO(e.getDefaultMessage(), e.getField());
			erroDTO.add(erroFormDTO);
		});
		return erroDTO;
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UsernameNotFoundException.class)
	public List<ErroPostDTO> handle(UsernameNotFoundException exception) {
		String message = exception.getMessage();
		List<ErroPostDTO> erroDTO = new ArrayList<>();
		erroDTO.add(new ErroPostDTO(message, "username"));
		return erroDTO;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResponseStatusException.class)
	public List<ErroNotFoundDTO> handle(ResponseStatusException exception) {
		String message = exception.getReason();
		List<ErroNotFoundDTO> errorList = new ArrayList<>();
		errorList.add(new ErroNotFoundDTO(message));
		return errorList;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalStateException.class)
	public List<ErroNotFoundDTO> handle(IllegalStateException exception) {
		List<ErroNotFoundDTO> errorList = new ArrayList<>();
		errorList.add(new ErroNotFoundDTO("Usuário possui artigo cadastrado."));
		return errorList;
	}
	

}
