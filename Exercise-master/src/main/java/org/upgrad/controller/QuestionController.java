package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.User;
import org.upgrad.services.QuestionService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @GetMapping("/api/question/all")
    public ResponseEntity<?> getAllQuestions(HttpSession session) {

        if (session.getAttribute("currUser") == null) {
            return new ResponseEntity<>("Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED);
        }
        else {
            User user = (User) session.getAttribute("currUser");
            String uname = user.getUserName();
            int userId = userService.findUserIdByName(uname);
            return new ResponseEntity<>(questionService.getAllQuestionsByUser(userId), HttpStatus.OK);
        }
    }

    @DeleteMapping("/api/question/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") int questionId,HttpSession session) {
        if (session.getAttribute("currUser") == null) {
            return new ResponseEntity<>("Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED);
        }
        else {
            User user = (User) session.getAttribute("currUser");
            String role = String.valueOf(userService.findUserRole(user.getUserName()));
            int userId = userService.findUserIdByName(user.getUserName());
            if (!String.valueOf(questionService.findUserIdfromQuestion(questionId)).equals("null") ) {
                int questionOwnerId = questionService.findUserIdfromQuestion(questionId);
                if (role.equalsIgnoreCase("admin") || (userId == questionOwnerId)) {
                    questionService.deleteQuestionWithId(questionId);
                    return new ResponseEntity<>("Question with questionId " + questionId + " deleted successfully.", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("You do not have rights to delete this question!", HttpStatus.UNAUTHORIZED);
                }
            }
            else {
                return new ResponseEntity<>("No question exists with  questionId " + questionId, HttpStatus.NO_CONTENT);
            }
        }
    }
}
