package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Integer> {

    @Query(nativeQuery = true,value="SELECT * FROM answer WHERE question_id= ?1 ")
    Iterable<Answer> getAllAnswersToQuestionId(int questionId);

    @Query(nativeQuery = true,value="SELECT * FROM answer WHERE user_id= ?1 ")
    Iterable<Answer> getAllAnswersByUserId(int userId);

    @Query(nativeQuery = true,value="SELECT count(*) from answer WHERE question_id= ?1")
    Integer getCountOfAnswersForQuestion(int questionId);
}
