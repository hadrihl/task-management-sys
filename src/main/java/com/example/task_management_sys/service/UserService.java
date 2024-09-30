package com.example.task_management_sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task_management_sys.entity.User;
import com.example.task_management_sys.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).get();
		if (user != null) {
			user.setUsername(userDetails.getUsername());
			user.setEmail(userDetails.getEmail());
			user.setPassword(userDetails.getPassword());
			return userRepository.save(user);
		}
		return null;
	}
	
	public boolean deleteUser(Long id) {
		User user = userRepository.findById(id).get();
		if (user != null) {
			userRepository.delete(user);
			return true;
		} else {
			return false;
		}
	}
}
