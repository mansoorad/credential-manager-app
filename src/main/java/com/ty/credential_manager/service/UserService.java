package com.ty.credential_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.credential_manager.dao.UserDao;
import com.ty.credential_manager.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user) {
		userDao.saveUser(user);
		return user;
	}
	
	public User getUserByName(User user) {
	User receivedUserName = userDao.getUserByName(user.getUserName());
	if(user.getPassword().equals(receivedUserName.getPassword())) {
		return receivedUserName;
	}else {
		return null;
	}
	}
	
	
	public User getUserByEmail(User user) {
		User recievedUser = userDao.getUserByEmail(user.getEmail());
		if(user.getPassword().equals(recievedUser.getPassword())) {
			return recievedUser;
		}else {
			return null;
		}
	}
	
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	public User deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
}
