package com.onlinetest.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.model.*;
public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public List<Quiz> findByCategory(Category category);
	
	
	
	public List<Quiz> findByActive(Boolean b);
//	--
	public List<Quiz> findByCategoryAndActive(Category category,Boolean T);

}
