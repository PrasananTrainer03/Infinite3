package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookingService {

	@Autowired
	BookingsRepository repo;
	
	@Autowired  
    JdbcTemplate jdbc;
	
	public void bookRoom(Bookings booking) {
		String cmd = "update room set status='Booked' where RoomId=?";
		jdbc.update(cmd, new Object[] {booking.getRoomid()});
		repo.save(booking);
	}
}
