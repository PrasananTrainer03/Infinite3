package com.example.demo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BillingDAO {

	@Autowired  
    JdbcTemplate jdbc;
	
	@Autowired
	RoomsDAO rdao;
	
	public String payBill(String bookId, Date checkOutDate) {
		Bookings booking = searchByBookId(bookId);
		Rooms room = rdao.searchByRoomId(booking.getRoomid());
		Date chekIn = booking.getChkdate();
		int secs = (int) (checkOutDate.getTime() - chekIn.getTime());
		int days = secs/(1000*60*60*24);
		int bill = days * room.getCostperday();	
		String cmd = "Insert into Billing(BookId, RoomId,NoOfDays,BillAmt) "
				+ " values(?,?,?,?)";
		jdbc.update(cmd, new Object[] {bookId,booking.getRoomid(),days,bill});
		cmd = "Update Room set status='Available' where RoomId=?";
		jdbc.update(cmd,new Object[] {booking.getRoomid()});
		return "Bill Paid...";
	}
	public Bookings searchByBookId(String bookId) {
		String cmd = "select * from Booking where BookID=?";
		List<Bookings> roomsList=null;
		roomsList=jdbc.query(cmd,new Object[] {bookId}, new RowMapper<Bookings>() {

			@Override
			public Bookings mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bookings bookings = new Bookings();
				bookings.setBookid(rs.getString("BookId"));
				bookings.setRoomid(rs.getString("roomId"));
				bookings.setCustname(rs.getString("custName"));
				bookings.setCity(rs.getString("city"));
				bookings.setBookdate(rs.getDate("BookDate"));
				bookings.setChkdate(rs.getDate("ChkDate"));
				return bookings;
			}
			
		});
		return roomsList.get(0);
	}
}
