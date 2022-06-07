package br.com.msansone.sanadmin.service;

import java.util.List;

import br.com.msansone.sanadmin.model.Parameter;

public interface ParameterService {

	Parameter addParameter(Parameter parameter);

	List<Parameter> getAll();

	Parameter getById(Long id);

	Parameter update(Parameter old) throws Exception;

	List<Parameter>  getByApplication(Long id);

}
