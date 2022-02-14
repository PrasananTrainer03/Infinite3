package com.example.demo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

	@Autowired
	private BillingDAO dao;
	
	@PostMapping("/billing/{bookId}/{checkoutDate}")
	public String payBill(@PathVariable String bookId, 
			@PathVariable Date checkoutDate) {
		return dao.payBill(bookId, checkoutDate);
	}
}
