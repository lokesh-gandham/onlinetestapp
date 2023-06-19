package com.onlinetest.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinetest.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
	
public User findByUsername(String username);       // findByUsername: write the properties as it is and use camelcase convention
	
	

}
