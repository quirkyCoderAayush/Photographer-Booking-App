package com.quirkycoder.photographerbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quirkycoder.photographerbookingapp.dto.JWTAuthenticationResponseUser;
import com.quirkycoder.photographerbookingapp.dto.RefreshTokenRequest;
import com.quirkycoder.photographerbookingapp.dto.UserLogin;
import com.quirkycoder.photographerbookingapp.dto.UserRegister;
import com.quirkycoder.photographerbookingapp.entity.User;
import com.quirkycoder.photographerbookingapp.service.UserAuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {
	
	@Autowired
	private final UserAuthenticationService userAuthenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody UserRegister userRegister) {
		return ResponseEntity.ok(userAuthenticationService.register(userRegister));
	}
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthenticationResponseUser> login(@RequestBody UserLogin userLogin) {
		return ResponseEntity.ok(userAuthenticationService.login(userLogin));
	}
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<JWTAuthenticationResponseUser> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return ResponseEntity.ok(userAuthenticationService.refreshToken(refreshTokenRequest));
	}

}
