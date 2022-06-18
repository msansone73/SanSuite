package br.com.msansone.sanlogin.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.sanlogin.model.LogMessage;
import br.com.msansone.sanlogin.service.LogService;

@RestController
@RequestMapping("/api/log")
public class LogMessageController {
	
	@Autowired
	LogService logService;
	
	
	@GetMapping
	public ResponseEntity<String> get(){
		return ResponseEntity.ok("started");
	}
	
	@PostMapping
	public void  addLog(@RequestBody LogMessage log) {
		logService.addLog(log);
		ResponseEntity.ok();
	}

}
