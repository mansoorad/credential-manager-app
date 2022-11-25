package com.ty.credential_manager.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.credential_manager.dto.Admin;
import com.ty.credential_manager.dto.User;

@Repository
public class AdminDao {
	@Autowired
	EntityManagerFactory entityManagerFactory ;

	public Admin saveAdmin(Admin admin) {

		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();

		et.begin();
		entityManager.persist(admin);
		et.commit();
		return admin;

	}

	public Admin updateAdmin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge( admin);
		entityTransaction.commit();

		return  admin;
	}

	public boolean deleteAdmin(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Admin admin = entityManager.find(Admin.class, id);
		if (admin != null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}

	public Admin  getAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Admin admin = entityManager.find(Admin.class, id);
		if (admin != null) {
			return admin;
		} else {
			return null;
		}

	}
	public List<Admin> getAllAdmin() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query =entityManager.createQuery("select a from Admin a")	;
		List<Admin> admin = query.getResultList();

		return admin;

	}
	public Admin getAdminByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query =entityManager.createQuery("select a from Admin a where a.email=?1",Admin.class);
		query.setParameter(1, email);
		return (Admin) query.getSingleResult();
	}
}


