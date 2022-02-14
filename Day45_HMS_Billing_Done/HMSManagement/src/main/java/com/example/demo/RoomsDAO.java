package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoomsDAO {

	@Autowired  
    JdbcTemplate jdbc;
	
	public String updateStatus(int roomid,String status) {
		String cmd = "Update Room set Status=? WHERE roomid=?";
		jdbc.update(cmd, new Object[] {status,roomid});
		return "Room Booked...";
	}
	
	public List<Rooms> showAvailableRooms() {
		String cmd = "select * from Room where Status='Available'";
		List<Rooms> roomsList=null;
		roomsList=jdbc.query(cmd, new RowMapper<Rooms>() {

			@Override
			public Rooms mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rooms rooms = new Rooms();
				rooms.setRoomid(rs.getString("RoomID"));
				rooms.setType(rs.getString("Type"));
				rooms.setStatus(rs.getString("Status"));
				rooms.setCostperday(rs.getInt("CostPerDay"));
				return rooms;
			}
			
		});
		return roomsList;
	}
	
	public List<Rooms> showBookedRooms() {
		String cmd = "select * from Room where Status='Booked'";
		List<Rooms> roomsList=null;
		roomsList=jdbc.query(cmd, new RowMapper<Rooms>() {

			@Override
			public Rooms mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rooms rooms = new Rooms();
				rooms.setRoomid(rs.getString("RoomID"));
				rooms.setType(rs.getString("Type"));
				rooms.setStatus(rs.getString("Status"));
				rooms.setCostperday(rs.getInt("CostPerDay"));
				return rooms;
			}
			
		});
		return roomsList;
	}
	
	public Rooms searchByRoomId(String roomid) {
		String cmd = "select * from Room where RoomID=?";
		List<Rooms> roomsList=null;
		roomsList=jdbc.query(cmd,new Object[] {roomid}, new RowMapper<Rooms>() {

			@Override
			public Rooms mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rooms rooms = new Rooms();
				rooms.setRoomid(rs.getString("RoomID"));
				rooms.setType(rs.getString("Type"));
				rooms.setStatus(rs.getString("Status"));
				rooms.setCostperday(rs.getInt("CostPerDay"));
				return rooms;
			}
			
		});
		return roomsList.get(0);
	}
}
