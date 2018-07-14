package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Question;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {
    @Override
    public List <Question> getAllQuestionsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List <Question> getAllQuestions() {
        return null;
    }
}
