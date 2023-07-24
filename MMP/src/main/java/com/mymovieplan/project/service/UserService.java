package com.mymovieplan.project.service;

import java.util.Set;

import com.mymovieplan.project.model.User;
import com.mymovieplan.project.model.UserRole;

public interface UserService {
	//create user
	public User createUser(User user , Set<UserRole> userRoles) throws Exception;
	//get user by username
	public User getUser(String username);
	//delete user by id
	public void deleteUser(Long userId);
	//update user
	public User updateUser(User user, Set<UserRole> userRoles);

}
