package br.com.msansone.sanadmin.service;

import java.util.List;

import br.com.msansone.sanadmin.model.Application;

public interface ApplicationService {

	List<Application> getAll();

	Application insert(Application application);

}
