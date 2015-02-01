package com.fudfil.edelivery.users.dao;

import java.util.List;

import com.fudfil.edelivery.users.dto.Users;

public interface IUsersDataDao {

	Users putUsersData(Users userData);

	Users getUsersData(String userId);

	void removeUsersData(String userId);

	List<Users> getAllUsersData();

	List<Users> getActiveUsers();

	List<Users> getInactiveUsers();

}
