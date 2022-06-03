package br.com.msansone.sanadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class Network {
	
	@GetMapping("/ping")
	public ResponseEntity<String> getPing(){
		return ResponseEntity.ok("live");
	}

}
