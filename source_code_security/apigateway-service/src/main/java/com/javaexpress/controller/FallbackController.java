package com.javaexpress.controller;

import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@PostMapping("/contactSupport")
	public ResponseEntity<String> handleFallBack() {
		return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE)
					.body("Service is Unavaiable,Please Contact Support Team");
	}
	
	@PutMapping("/contactSupport")
	public ResponseEntity<String> handleFallBack1() {
		return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE)
					.body("Service is Unavaiable,Please Contact Support Team");
	}
	
	@DeleteMapping("/contactSupport")
	public ResponseEntity<String> handleFallBack2() {
		return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE)
					.body("Service is Unavaiable,Please Contact Support Team");
	}
}
