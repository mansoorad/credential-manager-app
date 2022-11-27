
package com.ty.credential_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.credential_manager.dao.AdminDao;
import com.ty.credential_manager.dto.Admin;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	public Admin saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		return admin;
	}
	
	public Admin getAdminByEmail(Admin admin) {
		Admin recievedAdmin = adminDao.getAdminByEmail(admin.getEmail());
		if(admin.getPassword().equals(recievedAdmin.getPassword())) {
			return recievedAdmin;
		}else {
			return null;
		}
	}
	
	public List<Admin> getAllAdmin(){
		return adminDao.getAllAdmin();
	}
	
	public boolean deleteUser(int id) {
		return adminDao.deleteAdmin(id);
	}
	
	public Admin getUserById(int id) {
		return adminDao.getAdminById(id);
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}
}