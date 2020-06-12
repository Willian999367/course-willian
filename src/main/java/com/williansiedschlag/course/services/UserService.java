package com.williansiedschlag.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.williansiedschlag.course.entities.User;
import com.williansiedschlag.course.respositories.UserRepository;
import com.williansiedschlag.course.services.exceptions.DatabaseException;
import com.williansiedschlag.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}	
	
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	
	
	public User update(Long id, User obj) {
		
		// vou dar o nome de entity que vai ser uma unidade monitorada pelo 
		// JPA 
		// GetOne ele só prepara objeto depois vai no banco de dados (parecido com findby)
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
