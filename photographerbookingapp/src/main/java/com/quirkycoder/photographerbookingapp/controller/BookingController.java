package com.quirkycoder.photographerbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quirkycoder.photographerbookingapp.dto.BookingRequest;
import com.quirkycoder.photographerbookingapp.dto.BookingResponse;
import com.quirkycoder.photographerbookingapp.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
		return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
	}
	
	
//	@GetMapping
//	public List<Booking> getBookingsByPrice(@RequestParam Double maxPrice) {
//		
//	}

}
