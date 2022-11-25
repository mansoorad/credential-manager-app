package com.ty.credential_manager.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.credential_manager.dto.Application;

@Repository
public class ApplicationDao {
	@Autowired
	EntityManagerFactory entityManagerFactory ;

	public Application saveApplication(Application application) {

		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();

		et.begin();
		entityManager.persist(application);
		et.commit();
		return application;

	}

	public Application updateApplication(Application application) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge( application);
		entityTransaction.commit();

		return  application;
	}

	public boolean deleteApplication(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Application application = entityManager.find(Application.class, id);
		if (application != null) {
			entityTransaction.begin();
			entityManager.remove(application);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}

	public Application  getApplicationById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Application application = entityManager.find(Application.class, id);
		if (application != null) {
			return application;
		} else {
			return null;
		}

	}
	public List<Application> getAllApplication() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query =entityManager.createQuery("select a from Application a")	;
		List<Application> applications = query.getResultList();

		return applications;

	}
	public Application getApplicationByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query =entityManager.createQuery("select a from Application a where a.email=?1",Application.class);
		query.setParameter(1, email);
		return (Application) query.getSingleResult();


	}
}


