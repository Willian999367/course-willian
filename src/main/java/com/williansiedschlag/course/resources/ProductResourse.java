package com.williansiedschlag.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williansiedschlag.course.entities.Product;
import com.williansiedschlag.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")

public class ProductResourse {
	
		// Colocar a dependencia do ProductService(pacote service)
		@Autowired 
		private ProductService service; 

		
		// Função retorna uma lista de usuario List<Product>
		@GetMapping
		public ResponseEntity<List<Product>> findAll(){
		
		// Declaro uma var tipo lista
		// pelo service chamo a função FindAll criada no pacote ProductService
			
		List<Product> list  = service.FindAll();
		return ResponseEntity.ok().body(list);
	
		}
		
		// Requisição do tipo Get
		// Abaixo o get vai poder receber um id 
		@GetMapping(value = "/{id}") 
		
		//Método do tipo Product, por que vai retonar apenas um usuario
		//@PathVariable isso serve para framweork saber que id do GET
		public ResponseEntity<Product> findById(@PathVariable Long id){
			
			// Agora chamo a função Find passando o Id do método 
			Product obj = service.findById(id);
			
			return ResponseEntity.ok().body(obj);
		}
		
}
