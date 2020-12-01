package com.nextgate.assesment.dataaccessobjects;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.assesment.datatypes.User;

@Repository
public class UserDAO implements UserInterfaceDAO {
	
	@Autowired 
	private EntityManager mEntityManager;

	@Override
	public boolean Login(User aUser) {
		Session currentSession = mEntityManager.unwrap(Session.class);
		System.out.println(String.format("Building login query with username: %1$s and password: %2$s", aUser.getUsername(), aUser.getPassword()));
		Query<User> query = currentSession.createQuery("FROM User u where u.mUsername = ?0 and u.mPassword = ?1", User.class)
				.setParameter(0, aUser.getUsername())
				.setParameter(1, aUser.getPassword());
		List<User> allUsers = query.getResultList();
		switch(allUsers.size()) {
		case 0:
			System.out.println("No matching user found.");
			return false;
		
		case 1:
			System.out.println("Successfully logged in.");
			return true;
		default:
			System.out.println("The login query returned unexpected results.");
			return false;
		}
	}

}
