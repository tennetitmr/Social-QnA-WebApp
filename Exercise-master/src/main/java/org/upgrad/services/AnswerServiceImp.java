package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Answer;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {


    @Override
    public List <Answer> getAllAnswersToQuestion(Integer questionId) {
        return null;
    }

    @Override
    public List <Answer> getAllAnswersByLikes(Integer questionId) {
        return null;
    }
}