package com.williansiedschlag.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williansiedschlag.course.entities.Order;
import com.williansiedschlag.course.respositories.OrderRepository;

//Essa anotacao define como um compenete do spring
//Com isso vai poder ser injetado automaticamente com autowired
@Service

public class OrderService {
		
	@Autowired // Faça a injeção de dependencia
	private OrderRepository repository; 

	// Método para retonar todos usuarios do banco de dados
	
	public List<Order>FindAll(){
		return repository.findAll();
	}
	
	// Chamar o Order pelo id
	
	public Order findById(Long id) {
			
		Optional<Order> obj = repository.findById(id);
		// Vai retorna um Objeto tipo <Order> que estiver dentro o obg 
		return obj.get();
	}	
	
}
