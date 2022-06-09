package br.com.msansone.sanadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.msansone.sanadmin.exception.InvalidAuthenticationException;
import br.com.msansone.sanadmin.model.Usuario;
import br.com.msansone.sanadmin.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario update(Usuario usuario) throws Exception {
		Optional<Usuario> oOld = repository.findById(usuario.getId());
		if (oOld.isEmpty()) {
			throw new Exception("Usuario "+ usuario.getId() +" não encontrado.");
		}
		Usuario old = oOld.get();
		old.setName(usuario.getName());
		old.setLastName(usuario.getLastName());
		old.setEmail(usuario.getEmail());
		old.setPassword(usuario.getPassword());
		old.setActive(usuario.getActive());
		old.setApplication(usuario.getApplication());
		return repository.save(old);
		
	}
	
	@GetMapping
	public List<Usuario> getAll(){
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Usuario login(Long id, String email, String password) {
		return repository.findAllByApplicationIdAndEmailAndPassword(id,
				email, 
				password)
				.orElseThrow(() -> new InvalidAuthenticationException("Login Invalid!"));
		
	}

	@Override
	public Usuario inserir(Usuario usuario) {
		return repository.save(usuario);
	}


}
