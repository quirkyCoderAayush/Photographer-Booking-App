package com.quirkycoder.photographerbookingapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quirkycoder.photographerbookingapp.entity.User;
import com.quirkycoder.photographerbookingapp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	
	@GetMapping("/msg")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Welcome Admin :)");
	}
	
	@GetMapping("/all")
    //@PreAuthorize("hasRole('ADMIN')")  // Only Admins can access
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
