package com.pallavi.questionProject.service;

import com.pallavi.questionProject.entity.Question;
import com.pallavi.questionProject.entity.QuestionRequest;
import com.pallavi.questionProject.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    @DisplayName("Should throw an exception when the question details are null")
    void createQuestionWhenDetailsAreNullThenThrowException() {
        QuestionRequest questionRequest = null;

        assertThrows(IllegalArgumentException.class, () -> {
            questionService.createQuestion(questionRequest);
        });



        verify(questionRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should create a question with all the provided details")
    void createQuestionWithAllDetails() {
        QuestionRequest questionRequest = new QuestionRequest(
                "What is the capital of France?",
                "Paris",
                "London",
                "Berlin",
                "Madrid",
                "Geography",
                "Easy",
                "Paris"
        );

        Question expectedQuestion = new Question();
        expectedQuestion.setQuestion(questionRequest.question());
        expectedQuestion.setOption1(questionRequest.option1());
        expectedQuestion.setOption2(questionRequest.option2());
        expectedQuestion.setOption3(questionRequest.option3());
        expectedQuestion.setOption4(questionRequest.option4());
        expectedQuestion.setCategory(questionRequest.category());
        expectedQuestion.setCorrectAns(questionRequest.correctAns());
        expectedQuestion.setDifficultyLevel(questionRequest.difficultyLevel());

        when(questionRepository.save(any(Question.class))).thenReturn(expectedQuestion);

        questionService.createQuestion(questionRequest);

        verify(questionRepository, times(1)).save(expectedQuestion);
    }


}