package org.greg.backend.service;

import java.util.Optional;

import org.greg.backend.data.User;
import org.greg.backend.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
		}
		
		return user.get();
	}
}
