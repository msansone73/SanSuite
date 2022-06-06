package br.com.msansone.sanadmin.service;

import java.util.List;
import java.util.Optional;

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
	public Application insert(Application application) throws Exception {
		Optional<Application> mesmoNome = applicationRepository.findAllByName(application.getName());
		if (mesmoNome.isPresent()) {
			throw new Exception("Application "+ application.getName() +" exists.");
		}  else {
		return applicationRepository.save(application);
		}
	}

	@Override
	public Application update(Application application) {
		Application oldApp = applicationRepository.findById(application.getId()).orElseThrow();
		oldApp.setName(application.getName());
		oldApp.setDescription(application.getDescription());
		return applicationRepository.save(oldApp);
	}

	@Override
	public Application getById(Long id) {
		return applicationRepository.findById(id).orElse(null);
	}

	@Override
	public void del(Application app) {
		applicationRepository.delete(app);		
	}
	
	

}
