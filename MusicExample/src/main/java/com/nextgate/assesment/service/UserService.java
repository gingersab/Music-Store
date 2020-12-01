package com.nextgate.assesment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.dataaccessobjects.UserDAO;
import com.nextgate.assesment.datatypes.User;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDAO mUserDAO;
	
	@Transactional
	@Override
	public boolean Login(User aUser) {
		return mUserDAO.Login(aUser);
	}
}
