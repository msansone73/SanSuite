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
import br.com.msansone.sanadmin.service.ParameterService;

@RestController
@RequestMapping("/api/parameter")
public class ParameterController {
	
	@Autowired
	ParameterService parameterService;
	
	@PostMapping
	public ResponseEntity<Parameter> update(@RequestBody Parameter parameter){
		return ResponseEntity.ok(parameterService.addParameter(parameter));
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
	public ResponseEntity<Parameter> updateParameter(@RequestBody Parameter para){
		Parameter old= parameterService.getById(para.getId());
		if (old==null) {
			return ResponseEntity.notFound().build();
		}
		old.setCategory(para.getCategory());
		old.setKey(para.getKey());
		old.setValue(para.getValue());
		old.setApplication(para.getApplication());
		old.setActive(para.getActive());
		return ResponseEntity.ok(parameterService.update(old));
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
