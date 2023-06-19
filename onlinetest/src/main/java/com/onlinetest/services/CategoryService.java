package com.onlinetest.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.model.*;
import com.onlinetest.repo.*;
import com.onlinetest.services.*;
@Service
public class  CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	


	public Category addCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}


	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	
	public Set<Category> getCategories() {
		
		return  new LinkedHashSet<>( this.categoryRepository.findAll());
	}


	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}


	public void deleteCategory(Long categoryId) {
	Category category	=new Category();
	category.setCid(categoryId);
	this.categoryRepository.delete(category);
		
	}

}
