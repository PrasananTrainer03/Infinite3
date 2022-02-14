package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping("/bookRoom")
	public void bookRoom(@RequestBody Bookings booking) {
		service.bookRoom(booking);
	}
}
