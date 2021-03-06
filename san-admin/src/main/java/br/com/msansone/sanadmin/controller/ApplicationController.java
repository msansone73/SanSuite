package br.com.msansone.sanadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.sanadmin.model.Application;
import br.com.msansone.sanadmin.model.rest.ResponseGeneric;
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
	public ResponseEntity<ResponseGeneric> insert(@RequestBody Application application){
		try {
			return ResponseEntity.ok(new ResponseGeneric(applicationService.insert(application),null));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseGeneric(null,e));
		}		
	}
	
	@PutMapping
	public ResponseEntity<ResponseGeneric> update(@RequestBody Application application){
		try {
			return ResponseEntity.ok(new ResponseGeneric(applicationService.update(application),null));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseGeneric(null,e));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Application> getById(@PathVariable Long id) {
		Application app = applicationService.getById(id);
		if (app==null) {
			return ResponseEntity.notFound().build();			
		}
		return ResponseEntity.ok(app);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseGeneric> delById(@PathVariable Long id){
		Application app = applicationService.getById(id);
		if (app==null) {
			return ResponseEntity.notFound().build();			
		}
		try {
			applicationService.del(app);
			return ResponseEntity.ok(new ResponseGeneric(app, null));	
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseGeneric(null,e));
		}
		
	}

}
