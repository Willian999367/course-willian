package com.williansiedschlag.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
		//  ResponseEntity<User> vou retorno usuario inserido
		// @ResquestBody User obj - > receber u objeto tipo user 
		// @ResquestBody Para dizer que esse objeto vai chegar em mode json e vai ser 
		// modificado para um topo obejeto user, vou usar @ResquestBody 
		@PostMapping
		public ResponseEntity<User> insert(@RequestBody User obj){
			// Agora vou chamar meu service que já esta injetado 
			obj = service.insert(obj);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj); 
			
		}
		
		
		// Para o long id ser considerado uma variavel da url @PathVariable
		@DeleteMapping(value = "/{id}") 
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		// Para atualizar os dodos no http usa o método PUT
		@PutMapping(value = "/{id}")
		// Tipo User por que vou retornar o usuario atualizado
		public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
	
			obj = service.update(id, obj);
			return ResponseEntity.ok().body(obj); 
		}
}
