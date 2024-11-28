package com.quirkycoder.photographerbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quirkycoder.photographerbookingapp.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
}
