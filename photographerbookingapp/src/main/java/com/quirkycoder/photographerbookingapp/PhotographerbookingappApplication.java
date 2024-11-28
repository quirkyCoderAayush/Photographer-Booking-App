package com.quirkycoder.photographerbookingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quirkycoder.photographerbookingapp.entity.Role;
import com.quirkycoder.photographerbookingapp.entity.User;
import com.quirkycoder.photographerbookingapp.repository.UserRepository;

@SpringBootApplication
public class PhotographerbookingappApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PhotographerbookingappApplication.class, args);
		System.out.println("Hello quirkyCoder!!! Good luck with the project :)");
	}

	@Override
	public void run(String... args) throws Exception {
		
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		
		if(null == adminAccount) {
			User user = new User();
			
			user.setEmail("admin@gmail.com");
			user.setName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("2024Admin@@11"));
			user.setLocation("Begusarai");
			
			userRepository.save(user);
		}
		
	}

}
