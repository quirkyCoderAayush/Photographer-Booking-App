package com.quirkycoder.photographerbookingapp.dto;

import java.time.LocalDateTime;

import com.quirkycoder.photographerbookingapp.entity.Photographer;
import com.quirkycoder.photographerbookingapp.entity.User;

import lombok.Data;

@Data
public class BookingRequest {
	
	private Photographer photographer;
	
	private User user;
	
	private Double price;
	
	private LocalDateTime bookingDateAndTime;

}
