package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.model.Question;

import java.util.List;

@Repository
public interface QuestionRespository extends CrudRepository <Question, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM question")
    List <Question> getAllQuestions();
}
