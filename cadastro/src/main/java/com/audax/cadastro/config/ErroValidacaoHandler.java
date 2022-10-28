package com.audax.cadastro.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.audax.cadastro.dto.ErroNotFoundDTO;
import com.audax.cadastro.dto.ErroPostDTO;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroPostDTO> handle(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<ErroPostDTO> erroDTO = new ArrayList<>();
		fieldErrors.forEach(e -> {
			ErroPostDTO erroFormDTO = new ErroPostDTO(e.getField(), e.getDefaultMessage());
			erroDTO.add(erroFormDTO);
		});
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
	

}
