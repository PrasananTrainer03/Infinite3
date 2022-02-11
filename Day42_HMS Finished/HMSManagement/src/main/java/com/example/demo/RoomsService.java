package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomsService {

	@Autowired
	private RoomsRepository repo; 
	
	@Autowired
	private RoomsDAO rdao;
	
	public void addRoom(Rooms room) {
		repo.save(room);
	}
	
	public Rooms search(String roomid) {
		return repo.findById(roomid).get();
	}
	public List<Rooms> showRooms() {
		return repo.findAll();
	}
	
	public List<Rooms> showAvailableRooms() {
		return rdao.showAvailableRooms();
	}
	
	public List<Rooms> showBookedRooms() {
		return rdao.showBookedRooms();
	}
	
}
