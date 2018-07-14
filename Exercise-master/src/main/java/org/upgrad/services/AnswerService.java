package org.upgrad.services;

import org.upgrad.model.Answer;

import java.util.List;

public interface AnswerService {
    List <Answer> getAllAnswersToQuestion(Integer questionId);

    List <Answer> getAllAnswersByLikes(Integer questionId);
}
