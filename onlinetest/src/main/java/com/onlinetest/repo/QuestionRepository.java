package com.onlinetest.repo;

import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.model.*;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
