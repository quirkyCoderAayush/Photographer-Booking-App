package com.quirkycoder.photographerbookingapp.dto;

import lombok.Data;

@Data
public class JWTAuthenticationResponseUser {
	
	private String token;
	
	private String refreshToken;

}
