package br.com.msansone.sanadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.sanadmin.model.Application;
import br.com.msansone.sanadmin.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public List<Application> getAll() {
		return applicationRepository.findAll();
	}

	@Override
	public Application insert(Application application) {
		return applicationRepository.save(application);
	}

}
