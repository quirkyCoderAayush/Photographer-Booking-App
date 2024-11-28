package com.quirkycoder.photographerbookingapp.dto;

import lombok.Data;

@Data
public class BookingResponse {

	private Long bookingId;
	private String message;

	public BookingResponse(Long bookingId, String message) {
		this.bookingId = bookingId;
		this.message = message;
	}

}
