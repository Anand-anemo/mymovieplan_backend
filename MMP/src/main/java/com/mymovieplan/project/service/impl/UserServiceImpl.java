package com.mymovieplan.project.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.project.exception.UserAlreadyExistsException;
import com.mymovieplan.project.model.User;
import com.mymovieplan.project.model.UserRole;
import com.mymovieplan.project.repository.RoleRepository;
import com.mymovieplan.project.repository.UserRepository;
import com.mymovieplan.project.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User is already there");
			throw new UserAlreadyExistsException();
		}else {
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			
		}
		
		return this.userRepository.save(user);
	}
//getting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}
	//delete user by id
	@Override
	public void deleteUser(Long userId) {
	
		this.userRepository.deleteById(userId);
		
	}
	
	//update user
	@Override
	public User updateUser(User user, Set<UserRole> userRoles) {
		for(UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		return this.userRepository.save(user);
	}

}
