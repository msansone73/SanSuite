package br.com.msansone.sanadmin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.sanadmin.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	
	Optional<Application> findAllByName(String name);

}
