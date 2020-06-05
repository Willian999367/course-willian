package com.williansiedschlag.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williansiedschlag.course.entities.User;
import com.williansiedschlag.course.respositories.UserRepository;

//Essa anotacao define como um compenete do spring
//Com isso vai poder ser injetado automaticamente com autowired
@Service

public class UserService {
		
	@Autowired // Faça a injeção de dependencia
	private UserRepository repository; 

	// Método para retonar todos usuarios do banco de dados
	
	public List<User>FindAll(){
		return repository.findAll();
	}
	
	// Chamar o user pelo id
	
	public User findById(Long id) {
		
		
		Optional<User> obj = repository.findById(id);
		// Vai retorna um Objeto tipo <User> que estiver dentro o obg 
		return obj.get();
	}	
	
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	} 
	
}
