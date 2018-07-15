package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.User;
import org.upgrad.services.AnswerService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;

    @GetMapping("/api/answer/all/{questionId}")
    ResponseEntity<?> getAnswersByQuestionId(@PathVariable("questionId") int questionId, HttpSession session) {
        if (session.getAttribute("currUser") == null) {
            return new ResponseEntity<>("Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED);
        }
        else {
            if(!String.valueOf(answerService.isQuestionIdForAnswerValid(questionId)).equalsIgnoreCase("null")) {
                return new ResponseEntity<>(answerService.getAllAnswersToQuestion(questionId), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Question with id "+questionId+" doesn't contains answer",HttpStatus.NOT_FOUND);
            }
        }
    }

    @GetMapping("/api/answer/all")
    ResponseEntity<?> getAnswersByUserId(HttpSession session) {
        if (session.getAttribute("currUser") == null) {
            return new ResponseEntity<>("Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED);
        }
        else {
            User user = (User) session.getAttribute("currUser");
            String uname = user.getUserName();
            int userId = userService.findUserIdByName(uname);
            return new ResponseEntity<>(answerService.getAllAnswersByUser(userId), HttpStatus.OK);
        }
    }

}
