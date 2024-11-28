package com.quirkycoder.photographerbookingapp.service;

import com.quirkycoder.photographerbookingapp.dto.JWTAuthenticationResponseUser;
import com.quirkycoder.photographerbookingapp.dto.RefreshTokenRequest;
import com.quirkycoder.photographerbookingapp.dto.UserLogin;
import com.quirkycoder.photographerbookingapp.dto.UserRegister;
import com.quirkycoder.photographerbookingapp.entity.User;

public interface UserAuthenticationService {
	
	User register(UserRegister register);
	
	JWTAuthenticationResponseUser login(UserLogin login);
	
	JWTAuthenticationResponseUser refreshToken(RefreshTokenRequest refreshTokenRequest);

}
