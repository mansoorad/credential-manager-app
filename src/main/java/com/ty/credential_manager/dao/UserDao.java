package com.ty.credential_manager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.credential_manager.dto.User;

@Repository
public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public User saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();

		et.begin();
		entityManager.persist(user);
		et.commit();
		return user;

	}

	public User updateUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}

	public User deleteUser(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
		return user;

	}

	public User getUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			return user;
		} else {
			return null;
		}

	}

	public List<User> getAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from User s");
		List<User> users = query.getResultList();

		return users;

	}

	public User getUserByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select u from User u where u.email=?1", User.class);
		query.setParameter(1, email);
		return (User) query.getSingleResult();

	}
	
	public User getUserByName(String userName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select u from User u where u.userName=?1", User.class);
		query.setParameter(1, userName);
		return (User) query.getSingleResult();
	}
}