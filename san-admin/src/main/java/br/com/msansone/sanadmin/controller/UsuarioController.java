package br.com.msansone.sanadmin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.sanadmin.model.Usuario;
import br.com.msansone.sanadmin.model.rest.LoginRequest;
import br.com.msansone.sanadmin.model.rest.ResponseGeneric;
import br.com.msansone.sanadmin.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping
	public ResponseEntity<ResponseGeneric> inserir(@RequestBody Usuario usuario){
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			
			return ResponseEntity.ok(
					new ResponseGeneric(
							usuarioService.inserir(usuario), null));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new ResponseGeneric(null, e));
		}
	}
	
	@PutMapping
	public ResponseEntity<ResponseGeneric> update(@RequestBody Usuario usuario){
		try {
			return ResponseEntity.ok(
					new ResponseGeneric(
							usuarioService.update(usuario), null));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new ResponseGeneric(null, e));
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.getById(id);
		if (usuario.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(usuario.get());
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseGeneric> login(@RequestBody LoginRequest loginRequest){
		try {
			return ResponseEntity.ok(
					new ResponseGeneric(
							usuarioService.login(
									loginRequest.getApplicationId(),
									loginRequest.getEmail(), 
									loginRequest.getPassword()
									),
							null)
					);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new ResponseGeneric(null, e));
		}
	}
	
	
}
