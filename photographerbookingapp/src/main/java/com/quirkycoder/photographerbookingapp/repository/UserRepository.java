package com.quirkycoder.photographerbookingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quirkycoder.photographerbookingapp.entity.Role;
import com.quirkycoder.photographerbookingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	User findByRole(Role role);
	
	

}
