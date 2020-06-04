package com.williansiedschlag.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williansiedschlag.course.entities.Product;
import com.williansiedschlag.course.respositories.ProductRepository;

//Essa anotacao define como um compenete do spring
//Com isso vai poder ser injetado automaticamente com autowired
@Service

public class ProductService {
		
	@Autowired // Faça a injeção de dependencia
	private ProductRepository repository; 

	// Método para retonar todos usuarios do banco de dados
	
	public List<Product>FindAll(){
		return repository.findAll();
	}
	
	// Chamar o user pelo id
	
	public Product findById(Long id) {
		
		
		Optional<Product> obj = repository.findById(id);
		// Vai retorna um Objeto tipo <Product> que estiver dentro o obg 
		return obj.get();
	}	
	
}
