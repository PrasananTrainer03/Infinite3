package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

	@Autowired
	private EmployService service;
	
	@RequestMapping("/")
	public List<Employ> showEmploy() {
		return service.showEmploy();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Employ> get(@PathVariable Integer id) {
	    try {
	        Employ employ = service.searchEmploy(id);
	        return new ResponseEntity<Employ>(employ, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employ>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/add/emp")
	public void add(@RequestBody Employ employ) {
	    service.save(employ);
	}
	
	@DeleteMapping("/employs/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
}
