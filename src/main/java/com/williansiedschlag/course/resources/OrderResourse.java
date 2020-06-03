package com.williansiedschlag.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williansiedschlag.course.entities.Order;
import com.williansiedschlag.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")

public class OrderResourse {
	
		// Colocar a dependencia do OrderService(pacote service)
		@Autowired 
		private OrderService service; 

		
		// Função retorna uma lista de usuario List<Order>
		@GetMapping
		public ResponseEntity<List<Order>> findAll(){
		
		// Declaro uma var tipo lista
		// pelo service chamo a função FindAll criada no pacote OrderService
			
		List<Order> list  = service.FindAll();
		return ResponseEntity.ok().body(list);
	
		}
		
		// Requisição do tipo Get
		// Abaixo o get vai poder receber um id 
		@GetMapping(value = "/{id}") 
		
		//Método do tipo Order, por que vai retonar apenas um usuario
		//@PathVariable isso serve para framweork saber que id do GET
		public ResponseEntity<Order> findById(@PathVariable Long id){
			
			// Agora chamo a função Find passando o Id do método 
			Order obj = service.findById(id);
			
			return ResponseEntity.ok().body(obj);
		}
		
}
