package org.upgrad.services;

import org.upgrad.model.Question;

public interface QuestionService {

    Iterable<Question> getAllQuestionsByUser(int id);
    Integer findUserIdfromQuestion(int id);
    void deleteQuestionWithId(int id);

}
