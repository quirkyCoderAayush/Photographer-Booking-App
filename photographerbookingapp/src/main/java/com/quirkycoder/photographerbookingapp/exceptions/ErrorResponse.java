package com.quirkycoder.photographerbookingapp.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
	
private String message;
    
    public ErrorResponse(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

}
