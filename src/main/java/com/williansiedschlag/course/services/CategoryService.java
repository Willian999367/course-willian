package com.williansiedschlag.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williansiedschlag.course.entities.Category;
import com.williansiedschlag.course.respositories.CategoryRepository;

//Essa anotacao define como um compenete do spring
//Com isso vai poder ser injetado automaticamente com autowired
@Service

public class CategoryService {
		
	@Autowired // Faça a injeção de dependencia
	private CategoryRepository repository; 

	// Método para retonar todos usuarios do banco de dados
	
	public List<Category>FindAll(){
		return repository.findAll();
	}
	
	// Chamar o Category pelo id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		// Vai retorna um Objeto tipo <Category> que estiver dentro o obg 
		return obj.get();
	}	
	
}
