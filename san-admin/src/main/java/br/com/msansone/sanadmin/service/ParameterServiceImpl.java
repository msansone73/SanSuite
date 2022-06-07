package br.com.msansone.sanadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.sanadmin.model.Parameter;
import br.com.msansone.sanadmin.repository.ParameterRepository;

@Service
public class ParameterServiceImpl implements ParameterService{

	@Autowired
	ParameterRepository parameterRepository;
	
	@Override
	public Parameter addParameter(Parameter parameter) {
		return parameterRepository.save(parameter);
	}

	@Override
	public List<Parameter> getAll() {
		return parameterRepository.findAll();
	}

	@Override
	public Parameter getById(Long id) {
		return parameterRepository.findById(id).orElse(null);
	}

	@Override
	public Parameter update(Parameter para) throws Exception {
		Optional<Parameter> optOld = parameterRepository.findById(para.getId());
		if (optOld.isEmpty()) {
			throw new Exception("Parametro "+para.getId()+" inexistente!");
		}
		
		Parameter old = optOld.get();
		old.setCategory(para.getCategory());
		old.setKey(para.getKey());
		old.setValue(para.getValue());
		old.setApplication(para.getApplication());
		old.setActive(para.getActive());	
		
		return parameterRepository.save(old);
	}

	@Override
	public List<Parameter> getByApplication(Long id) {
		return parameterRepository.findAllByApplicationId(id);
	}

}
