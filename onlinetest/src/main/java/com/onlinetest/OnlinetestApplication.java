package com.onlinetest;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.onlinetest.exception.UserFoundException;
import com.onlinetest.model.Role;
import com.onlinetest.model.User;
import com.onlinetest.model.UserRole;
import com.onlinetest.services.UserService;

@SpringBootApplication
public class OnlinetestApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public static void main(String[] args) {
	SpringApplication.run(OnlinetestApplication.class, args);
}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("starting code");
			
			
		User user =new User();
			user.setFirstName("lokesh");
			user.setLastName("gandam");
			user.setUsername("lokeshaditya");
			
			user.setPassword(this.bCryptPasswordEncoder.encode("Lokesh@2721"));
			user.setEmail("lokeshaditya@gmail.com");
			user.setProfile("default.png");
			
			Role role1=new Role();
			role1.setRoleId(44L);
			role1.setRoleName("ADMIN");
			
			
			Set<UserRole> userRoleSet=new HashSet<>();
			UserRole userRole=new UserRole();
			
			userRole.setRole(role1);
			userRole.setUser(user);
			
			userRoleSet.add(userRole);
			
			User user1=this.userService.createUser(user, userRoleSet);
			
			System.out.println(user1.getUsername());
			
			}catch(UserFoundException e) {
				e.printStackTrace();
			}
			
//			
			
		}

		
		
	}

