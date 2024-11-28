package com.quirkycoder.photographerbookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.quirkycoder.photographerbookingapp.entity.User;

public interface UserService {
	
	UserDetailsService userDetailsService();

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	User updateUser(Long id, User updatedUser);

	void deleteUserById(Long id);

}
