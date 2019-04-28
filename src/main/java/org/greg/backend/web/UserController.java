package org.greg.backend.web;

import org.greg.backend.data.User;
import org.greg.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = userService.getUserById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
