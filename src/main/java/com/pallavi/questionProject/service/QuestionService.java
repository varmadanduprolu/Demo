package com.pallavi.questionProject.service;

import com.pallavi.questionProject.entity.Question;
import com.pallavi.questionProject.entity.QuestionRequest;
import com.pallavi.questionProject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService  {

    @Autowired
    private QuestionRepository questionRepository;
    public void createQuestion(QuestionRequest questionRequest) {
        Question question=new Question();
        question.setQuestion(questionRequest.question());
        question.setOption1(questionRequest.option1());
        question.setOption2(questionRequest.option2());
        question.setOption3(questionRequest.option3());
        question.setOption4(questionRequest.option4());
        question.setCategory(questionRequest.category());
        question.setCorrectAns(questionRequest.correctAns());
        question.setDifficultyLevel(questionRequest.difficultyLevel());
        questionRepository.save(question);
    }

    public Question getQuestionById(Integer id) {
       return questionRepository.findQuestionById(id);
    }


    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getAllQuestion() {
      return questionRepository.findAll();
    }
}
