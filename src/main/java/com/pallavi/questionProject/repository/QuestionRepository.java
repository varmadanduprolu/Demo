package com.pallavi.questionProject.repository;

import com.pallavi.questionProject.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    public Question findQuestionById(Integer id);

}
