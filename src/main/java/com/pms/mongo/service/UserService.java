package com.pms.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.mongo.dto.UserDTO;
import com.pms.mongo.entity.User;
import com.pms.mongo.repository.UserRepository;
import com.pms.mongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
