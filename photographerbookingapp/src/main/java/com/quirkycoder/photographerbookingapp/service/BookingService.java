package com.quirkycoder.photographerbookingapp.service;

import java.util.List;

import com.quirkycoder.photographerbookingapp.dto.BookingRequest;
import com.quirkycoder.photographerbookingapp.dto.BookingResponse;
import com.quirkycoder.photographerbookingapp.entity.Booking;

public interface BookingService {

	BookingResponse createBooking(BookingRequest bookingRequest);

	List<Booking> getBookingsByPrice(Double maxPrice);

	BookingResponse approveBooking(Long bookingId);

	BookingResponse rejectBooking(Long bookingId);

}
