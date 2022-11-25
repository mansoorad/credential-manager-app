package com.ty.credential_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.credential_manager.dao.ApplicationDao;
import com.ty.credential_manager.dto.Admin;
import com.ty.credential_manager.dto.Application;

@Service
public class ApplicationService {
	@Autowired
	ApplicationDao applicationDao;
	
	public Application saveApplication(Application application) {
		return applicationDao.saveApplication(application);		
	}
	
	public List<Application> getAllApplication(){
		return applicationDao.getAllApplication();
	}
	
	public boolean deleteApplication(int id) {
		return applicationDao.deleteApplication(id);
	}
	
	public Application getApplicationById(int id) {
		return applicationDao.getApplicationById(id);
	}
	
	public Application updateApplication(Application application) {
		return applicationDao.updateApplication(application);
	}
}
