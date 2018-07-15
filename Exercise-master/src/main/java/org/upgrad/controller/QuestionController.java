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

    /*
     * This QuestionService consist of all the implementations of business logic related to questions information of the app and
     * interact with repositories to access/store data in the database.
     */

    @Autowired
    private QuestionService questionService;

    /*
     * This UserService consist of all the implementations of business logic related to user login information of the app and
     * interact with repositories to access/store data in the database.
     */
    @Autowired
    private UserService userService;

    /*
    * This end point is implemented to get all the questions posted by that user
     */

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

    /*
     * This end point is implemented to delete the questions posted by that user
     *  Also 'admin' can delete the question posted by any  user
     */

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
