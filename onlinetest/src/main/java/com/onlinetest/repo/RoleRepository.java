package com.onlinetest.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinetest.model.*;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
