package br.com.msansone.sanadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.sanadmin.model.Application;
import br.com.msansone.sanadmin.service.ApplicationService;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping
	public ResponseEntity<List<Application>> getAll(){
		return ResponseEntity.ok(applicationService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Application> insert(@RequestBody Application application){
		return ResponseEntity.ok(applicationService.insert(application));		
	}

}
