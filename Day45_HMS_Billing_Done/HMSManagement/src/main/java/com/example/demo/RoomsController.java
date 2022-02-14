package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomsController {

	@Autowired
	private RoomsService service;
	
	@RequestMapping(value="/showRooms")
	public List<Rooms> list() {
		return service.showRooms();
	}
	
	@RequestMapping("/rooms/{id}")
	public ResponseEntity<Rooms> get(@PathVariable String id) {
		try {
		Rooms rooms = service.search(id);
		return new ResponseEntity<Rooms>(rooms,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Rooms>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/roomsAvailable")
	public List<Rooms> showAvailableRooms() {
		return service.showAvailableRooms();
	}
	
	@PostMapping("/addRoom")
	public void addRoom(@RequestBody Rooms room) {
		service.addRoom(room);
	}
	
	@RequestMapping(value="/roomsBooked")
	public List<Rooms> showBookedRooms() {
		return service.showBookedRooms();
	}
	
}
