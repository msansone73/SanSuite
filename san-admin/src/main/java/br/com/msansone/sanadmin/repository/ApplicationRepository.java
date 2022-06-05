package br.com.msansone.sanadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.sanadmin.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
