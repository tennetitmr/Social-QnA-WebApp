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

    // This method retrieves all the answers posted for particular question id
    @Override
    public Iterable<Answer> getAllAnswersToQuestion(int questionId) {
        return answerRepository.getAllAnswersToQuestionId(questionId);
    }

    // This method retrieves all the answers posted by particular user id
    @Override
    public Iterable<Answer> getAllAnswersByUser(int userId) {
        return answerRepository.getAllAnswersByUserId(userId);
    }

    // This method checks if there are any answers for the given question if
    @Override
    public Integer isQuestionIdForAnswerValid(int questionId) {
        return answerRepository.getCountOfAnswersForQuestion(questionId);

    }
}
