package com.onlinetest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
