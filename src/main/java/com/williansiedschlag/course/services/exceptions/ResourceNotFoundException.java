package com.williansiedschlag.course.services.exceptions;


// Essa classe será uma sub classe, exceção que o compilador n te obriga a tratar  
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		// Chamar o construtor da super classe com metodo super 
		super("Resource not found. ID " + id); 
	}
	
}
