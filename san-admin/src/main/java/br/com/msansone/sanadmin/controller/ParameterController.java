package br.com.msansone.sanadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.sanadmin.model.Parameter;
import br.com.msansone.sanadmin.model.rest.ResponseGeneric;
import br.com.msansone.sanadmin.service.ParameterService;

@RestController
@RequestMapping("/api/parameter")
public class ParameterController {
	
	@Autowired
	ParameterService parameterService;
	
	@PostMapping
	public ResponseEntity<ResponseGeneric> update(@RequestBody Parameter parameter){
		try {
			return ResponseEntity.ok(new ResponseGeneric(parameterService.addParameter(parameter), null));	
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseGeneric(null,e));
		}			
	}

	@GetMapping
	public ResponseEntity<List<Parameter>> getAll(){
		return ResponseEntity.ok(parameterService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parameter> getById(@PathVariable Long id){
		Parameter para = parameterService.getById(id);
		if (para==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(para);
	}
	
	@PutMapping
	public ResponseEntity<ResponseGeneric> updateParameter(@RequestBody Parameter para){
		try {
			return ResponseEntity.ok(new ResponseGeneric(parameterService.update(para), null));	
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new ResponseGeneric(null,e));
		}
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<List<Parameter>> getByApplication(@PathVariable Long id){
		List<Parameter> para = parameterService.getByApplication(id);
		if (para.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(para);
	}
	
}
