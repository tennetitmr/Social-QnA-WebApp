package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Answer;
import org.upgrad.repository.AnswerRepository;

@Service
public class AnswerServiceImp implements AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerServiceImp(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Iterable<Answer> getAllAnswersToQuestion(int questionId) {
        return answerRepository.getAllAnswersToQuestionId(questionId);
    }

    @Override
    public Iterable<Answer> getAllAnswersByUser(int userId) {
        return answerRepository.getAllAnswersByUserId(userId);
    }

    @Override
    public Integer isQuestionIdForAnswerValid(int questionId) {
        return answerRepository.getCountOfAnswersForQuestion(questionId);

    }
}
