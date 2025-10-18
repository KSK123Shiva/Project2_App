package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

	@PostMapping(value = "/book", consumes = { "application/json", "application/xml" })
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		System.out.println(book);

		// logic to store in DB

		String msg = "Book Added Succesfully";

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
}