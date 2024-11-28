package com.quirkycoder.photographerbookingapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quirkycoder.photographerbookingapp.entity.User;
import com.quirkycoder.photographerbookingapp.repository.UserRepository;
import com.quirkycoder.photographerbookingapp.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository;

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) {

				return userRepository.findByEmail(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found"));

			}
		};

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id:" +id));
		
		existingUser.setName(updatedUser.getName());
	    existingUser.setEmail(updatedUser.getEmail());
	    existingUser.setRole(updatedUser.getRole());
	    existingUser.setLocation(updatedUser.getLocation());
	    
	    return userRepository.save(existingUser);
	}

	@Override
	public void deleteUserById(Long id) {
		
		User existingUser = userRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

		if ("ADMIN".equals(existingUser.getRole().toString())) {
	        throw new AccessDeniedException("You are not allowed to delete a user with the ADMIN role.");
	    }
		
		if (!userRepository.existsById(id)) {
	        throw new EntityNotFoundException("User not found with id: " + id);
	    }

	    userRepository.deleteById(id);
		
	}


}
