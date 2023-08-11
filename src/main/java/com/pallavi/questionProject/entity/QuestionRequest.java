package com.pallavi.questionProject.entity;

public record QuestionRequest(String question,
                              String option1,
                              String option2,
                              String option3,
                              String option4,
                              String category,
                              String difficultyLevel,
                              String correctAns) {
}
