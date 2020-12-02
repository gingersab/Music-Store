package com.nextgate.assesment.dataaccessobjects;

import com.nextgate.assesment.datatypes.User;

public interface UserInterfaceDAO {
	boolean Login(User aUser);
	void addNewUser(User aUser);
}
