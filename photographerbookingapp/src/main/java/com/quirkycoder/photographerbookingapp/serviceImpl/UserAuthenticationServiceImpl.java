package com.quirkycoder.photographerbookingapp.serviceImpl;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quirkycoder.photographerbookingapp.dto.JWTAuthenticationResponseUser;
import com.quirkycoder.photographerbookingapp.dto.RefreshTokenRequest;
import com.quirkycoder.photographerbookingapp.dto.UserLogin;
import com.quirkycoder.photographerbookingapp.dto.UserRegister;
import com.quirkycoder.photographerbookingapp.entity.Role;
import com.quirkycoder.photographerbookingapp.entity.User;
import com.quirkycoder.photographerbookingapp.repository.UserRepository;
import com.quirkycoder.photographerbookingapp.service.JWTService;
import com.quirkycoder.photographerbookingapp.service.UserAuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	private final JWTService jwtService;

	@Override
	public User register(UserRegister register) {
		
		User user = new User();
		
		user.setEmail(register.getEmail());
		user.setName(register.getName());
		user.setPassword(passwordEncoder.encode(register.getPassword()));
		user.setRole(Role.USER);
		user.setLocation(register.getLocation());
		
		return userRepository.save(user);
	}

	public JWTAuthenticationResponseUser login(UserLogin login) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		var user = userRepository.findByEmail(login.getEmail())
				.orElseThrow(() -> new UsernameNotFoundException("Invalid email or password!!"));
		
		var jwt = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
		
		JWTAuthenticationResponseUser jwtAuthenticationResponseUser = new JWTAuthenticationResponseUser();
		
		jwtAuthenticationResponseUser.setToken(jwt);
		jwtAuthenticationResponseUser.setRefreshToken(refreshToken);
		
		return jwtAuthenticationResponseUser;
	}

	public JWTAuthenticationResponseUser refreshToken(RefreshTokenRequest refreshTokenRequest) {
		String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
		
		User user = userRepository.findByEmail(userEmail).orElseThrow();
		
		if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);
			
			JWTAuthenticationResponseUser jwtAuthenticationResponseUser = new JWTAuthenticationResponseUser();
			
			jwtAuthenticationResponseUser.setToken(jwt);
			jwtAuthenticationResponseUser.setRefreshToken(refreshTokenRequest.getToken());
			
			return jwtAuthenticationResponseUser;
		}
		return null;
	}

}
