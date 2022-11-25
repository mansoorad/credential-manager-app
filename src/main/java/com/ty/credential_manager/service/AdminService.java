package com.ty.credential_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.credential_manager.dao.AdminDao;
import com.ty.credential_manager.dto.Admin;
import com.ty.credential_manager.dto.User;
@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	public Admin saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		return admin;
	}
	
	public User getUserByEmail(User user) {
		User recievedUser = adminDao.getUserByEmail(user.getEmail());
		if(user.getPassword().equals(recievedUser.getPassword())) {
			return recievedUser;
		}else {
			return null;
		}
	}
	
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
}
