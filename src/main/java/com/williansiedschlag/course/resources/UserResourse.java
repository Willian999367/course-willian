package com.williansiedschlag.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williansiedschlag.course.entities.User;

@RestController
@RequestMapping(value = "/users")

public class UserResourse {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User (1L,"Willian","willian@com","333-444","12345");
		return ResponseEntity.ok().body(u);
	}

}
