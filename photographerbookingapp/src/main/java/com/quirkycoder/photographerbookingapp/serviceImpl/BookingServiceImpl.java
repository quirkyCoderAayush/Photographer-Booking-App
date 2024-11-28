package com.quirkycoder.photographerbookingapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quirkycoder.photographerbookingapp.dto.BookingRequest;
import com.quirkycoder.photographerbookingapp.dto.BookingResponse;
import com.quirkycoder.photographerbookingapp.entity.Booking;
import com.quirkycoder.photographerbookingapp.repository.BookingRepository;
import com.quirkycoder.photographerbookingapp.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public BookingResponse createBooking(BookingRequest bookingRequest) {
		
		Booking booking = new Booking();
		
		booking.setPhotographer(bookingRequest.getPhotographer());
		booking.setUser(bookingRequest.getUser());
		booking.setPrice(booking.getPrice());
		booking.setBookingDateAndTime(bookingRequest.getBookingDateAndTime());
		booking.setStatus("PENDING");
		
		Booking savedBooking = bookingRepository.save(booking);
		
		return new BookingResponse(savedBooking.getId(), "Booking created successfully!");
		
	}

	@Override
	public List<Booking> getBookingsByPrice(Double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponse approveBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingResponse rejectBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
