package org.upgrad.services;

import org.upgrad.model.Question;

import java.util.List;

public interface QuestionService {

    List <Question> getAllQuestionsByCategory(Integer categoryId);

    List <Question> getAllQuestions();
}
