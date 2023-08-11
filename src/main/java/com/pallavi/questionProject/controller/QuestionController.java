package com.pallavi.questionProject.controller;

import com.pallavi.questionProject.entity.Question;
import com.pallavi.questionProject.entity.QuestionRequest;
import com.pallavi.questionProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
//@RequiredArgsConstructor
public class QuestionController {

   @Autowired
    private QuestionService questionService;

    @PostMapping("/new")
    public void createQuestion(
            @RequestBody QuestionRequest questionRequest){

        questionService.createQuestion(questionRequest);
    }

    @GetMapping("/id/{id}")
    public Question getQuestionById(@PathVariable("id") Integer id){
        return questionService.getQuestionById(id);
    }
    @GetMapping("/all")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @DeleteMapping("/id/{id}")
    public void deleteQuestionById(@PathVariable("id") Integer id){
         questionService.deleteQuestionById(id);
    }

}
