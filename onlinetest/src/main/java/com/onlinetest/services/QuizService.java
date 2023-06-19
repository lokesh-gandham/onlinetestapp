package com.onlinetest.services;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.model.*;
import com.onlinetest.repo.*;
@Service
public class QuizService{
	@Autowired
	private QuizRepository quizRepository;

	
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}


	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepository.findAll());
	}


	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(quizId).get();
	}


	public void deleteQuiz(Long quizId) {
//		Quiz quiz=new Quiz();
//		quiz.setqId(quizId);
		this.quizRepository.deleteById(quizId);
//		this.quizRepository.delete(quiz);
	}

	
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizRepository.findByCategory(category);
	}

	
	
	// get active quizzes
	

	public List<Quiz> getActiveQuizzes() {
		// TODO Auto-generated method stub
		return this.quizRepository.findByActive(true);
	}
//

	public List<Quiz> getActiveQuizzesofCategory(Category c) {
		// TODO Auto-generated method stub
		return this.quizRepository.findByCategoryAndActive(c,true);
	}

}
