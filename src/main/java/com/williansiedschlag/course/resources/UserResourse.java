package com.williansiedschlag.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williansiedschlag.course.entities.User;
import com.williansiedschlag.course.services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResourse {
	
		// Colocar a dependencia do UserService(pacote service)
		@Autowired 
		private UserService service; 

		
		// Função retorna uma lista de usuario List<User>
		@GetMapping
		public ResponseEntity<List<User>> findAll(){
		
		// Declaro uma var tipo lista
		// pelo service chamo a função FindAll criada no pacote UserService
			
		List<User> list  = service.FindAll();
		return ResponseEntity.ok().body(list);
	
		}
		
		// Requisição do tipo Get
		// Abaixo o get vai poder receber um id 
		@GetMapping(value = "/{id}") 
		
		//Método do tipo User, por que vai retonar apenas um usuario
		//@PathVariable isso serve para framweork saber que id do GET
		public ResponseEntity<User> findById(@PathVariable Long id){
			
			// Agora chamo a função Find passando o Id do método 
			User obj = service.findById(id);
			
			return ResponseEntity.ok().body(obj);
		}
		
}
