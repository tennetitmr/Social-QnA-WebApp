package org.upgrad.services;

import org.upgrad.model.Answer;

public interface AnswerService {
    Iterable<Answer> getAllAnswersToQuestion(int questionId);
    Iterable<Answer> getAllAnswersByUser(int userId);
    Integer isQuestionIdForAnswerValid(int questionId);
}
