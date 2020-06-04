package com.williansiedschlag.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williansiedschlag.course.entities.Category;
import com.williansiedschlag.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResourse {
	
		// Colocar a dependencia do CategoryService(pacote service)
		@Autowired 
		private CategoryService service; 

		
		// Função retorna uma lista de usuario List<Category>
		@GetMapping
		public ResponseEntity<List<Category>> findAll(){
		
		// Declaro uma var tipo lista
		// pelo service chamo a função FindAll criada no pacote CategoryService
			
		List<Category> list  = service.FindAll();
		return ResponseEntity.ok().body(list);
	
		}
		
		// Requisição do tipo Get
		// Abaixo o get vai poder receber um id 
		@GetMapping(value = "/{id}") 
		
		//Método do tipo Category, por que vai retonar apenas um usuario
		//@PathVariable isso serve para framweork saber que id do GET
		public ResponseEntity<Category> findById(@PathVariable Long id){
			
			// Agora chamo a função Find passando o Id do método 
			Category obj = service.findById(id);
			
			return ResponseEntity.ok().body(obj);
		}
		
}
