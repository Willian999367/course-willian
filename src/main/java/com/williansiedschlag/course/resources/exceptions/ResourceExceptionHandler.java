package com.williansiedschlag.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.williansiedschlag.course.services.exceptions.ResourceNotFoundException;


// Anotação que vai intercepetar a execção para que esse objeto posso executar um 
// tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	// Com antação abaixo, a hora que acontece uma exeção do tipo "ResourceNotFoundException"
	// a classe abaixo é acionada 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	

	
}
