package br.com.msansone.sanadmin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.sanadmin.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findAllByEmailAndPassword(String email, String password);

}
