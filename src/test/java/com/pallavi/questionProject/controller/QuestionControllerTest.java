package com.pallavi.questionProject.controller;

import com.pallavi.questionProject.entity.Question;
import com.pallavi.questionProject.exception.ResourceNotFoundException;
import com.pallavi.questionProject.service.QuestionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;

    @Test
    @DisplayName("Should throw an exception when the id does not exist")
    void getQuestionByIdWhenIdDoesNotExistThenThrowException() {
        Integer id = 1;
        when(questionService.getQuestionById(id)).thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> {
            questionController.getQuestionById(id);
        });

        verify(questionService, times(1)).getQuestionById(id);
    }

    @Test
    @DisplayName("Should return the question when the id exists")
    void getQuestionByIdWhenIdExists() {
        Integer id = 1;
        Question question = new Question();
        question.setId(id);
        question.setQuestion("What is the capital of France?");
        question.setOption1("Paris");
        question.setOption2("London");
        question.setOption3("Berlin");
        question.setOption4("Madrid");
        question.setCategory("Geography");
        question.setDifficultyLevel("Easy");
        question.setCorrectAns("Paris");

        when(questionService.getQuestionById(id)).thenReturn(question);

        Question result = questionController.getQuestionById(id);

        assertEquals(question, result);
        verify(questionService, times(1)).getQuestionById(id);
    }

}