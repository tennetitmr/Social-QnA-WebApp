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

    // This method retrieves all the answers posted by user
    @Override
    public Iterable<Question> getAllQuestionsByUser(int id) {
        return questionRepository.getAllQuestionsByUserId(id);
    }

    // This method find the userid of a particular question
    @Override
    public Integer findUserIdfromQuestion(int id) {
        return questionRepository.getQuestionIdByUserId(id);
    }

    //This method delete the question with reference as questionId
    @Override
    public void deleteQuestionWithId(int id) {
        questionRepository.deleteQuestionById(id);
    }
}
