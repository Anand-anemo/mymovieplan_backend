package com.mymovieplan.project;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mymovieplan.project.exception.UserAlreadyExistsException;
import com.mymovieplan.project.model.Role;
import com.mymovieplan.project.model.User;
import com.mymovieplan.project.model.UserRole;
import com.mymovieplan.project.service.UserService;

@SpringBootApplication
public class MyMoviePlanApplication implements CommandLineRunner  {
	@Autowired
	private  UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args){
		SpringApplication.run(MyMoviePlanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("start the application");
		//creating user
		try {
		User user = new User();
		
		user.setFirstName("Anand");
		user.setLastName("Rawat");
		user.setUsername("anemo");
		user.setPassword(this.bCryptPasswordEncoder.encode("qazwsxedc"));
		user.setEmail("anand@gmail");
		user.setProfile("default.png");
		user.setMobileno("1234543212");
		//creating role
		Role role1=new Role();
		
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		Set<UserRole>userRoleSet = new HashSet<>();
		//creating user role with role and user
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		
		User user1  =this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		}
			catch(UserAlreadyExistsException e) {
				e.printStackTrace();
			}
		
		
	}

}
