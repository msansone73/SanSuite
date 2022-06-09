package br.com.msansone.sanadmin.service;

import java.util.List;
import java.util.Optional;

import br.com.msansone.sanadmin.model.Usuario;

public interface UsuarioService {

	Usuario update(Usuario usuario) throws Exception;

	Optional<Usuario> getById(Long id);

	List<Usuario> getAll();

	Usuario login(Long id, String email, String password);

	Usuario inserir(Usuario usuario);

}
