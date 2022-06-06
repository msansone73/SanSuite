package br.com.msansone.sanadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.sanadmin.model.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter,Long>{
	
	List<Parameter> findAllByApplicationId(Long id);

}
