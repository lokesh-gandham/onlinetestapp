package com.onlinetest.services;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.model.*;
import com.onlinetest.repo.*;
import com.onlinetest.exception.*;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	// creating user
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception  {
		
		User local=this.userRepository.findByUsername(user.getUsername());        // check user is allready avialabe or not
		
		if(local!=null) {
			System.out.println("user is allready there ! !");
//			throw new Exception("User already present");
			throw new UserFoundException();
		}else {
			// user create
			
			for(UserRole ur:userRoles) {				// userRole.getRole()  [
				roleRepository.save(ur.getRole());      //Role ke class ke data ko save kiya hai// when dont need to save UserRole seprately because we applied cascade in user class when we save user UserRole get automatically saved
			}
			
			
			user.getUserRoles().addAll(userRoles);  // setting userRoles
			local=this.userRepository.save(user);
		}
		
		return local;
	}



	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}



	public void deleteUser(Long userId) {
	this.userRepository.deleteById(userId);
		
	}

	
}
