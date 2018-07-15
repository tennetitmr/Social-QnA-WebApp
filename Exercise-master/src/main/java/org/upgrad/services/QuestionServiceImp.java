package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Question;
import org.upgrad.repository.QuestionRepository;

@Service
public class QuestionServiceImp implements QuestionService{

    private final QuestionRepository questionRepository;

    public QuestionServiceImp(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Iterable<Question> getAllQuestionsByUser(int id) {
        return questionRepository.getAllQuestionsByUserId(id);
    }

    @Override
    public Integer findUserIdfromQuestion(int id) {
        return questionRepository.getQuestionIdByUserId(id);
    }

    @Override
    public void deleteQuestionWithId(int id) {
        questionRepository.deleteQuestionById(id);
    }
}
