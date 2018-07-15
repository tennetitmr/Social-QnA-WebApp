package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.model.Question;
import org.upgrad.repository.QuestionRespository;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRespository questionRespository;
    @Override
    public List <Question> getAllQuestionsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List <Question> getAllQuestions() {
        return questionRespository.getAllQuestions ();
    }
}
