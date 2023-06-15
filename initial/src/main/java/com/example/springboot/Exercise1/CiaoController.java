package com.example.springboot.Exercise1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiaoController {

	@GetMapping("/")
	public String response() {
		return("Hello Spring!");
	}

	@GetMapping("/ciao")
	public String responseHello() {
		return ("CIAO World!");
	}

	@GetMapping("/greeting")
	public ResponseEntity<String> responseGreeting(){
		return ResponseEntity.ok("Good Afternoon!");
	}
}


