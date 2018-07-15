package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.User;
import org.upgrad.services.AnswerService;

import javax.servlet.http.HttpSession;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/api/answer/all/{questionId}")
    public ResponseEntity <?> getAllAnswersToQuestion(@PathVariable("questionId") Integer questionId, HttpSession session) {

        if (session.getAttribute ( "currUser" ) == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {

            return new ResponseEntity <> ( answerService.getAllAnswersToQuestion ( questionId ), HttpStatus.OK );

        }

    }

    @GetMapping("/api/answer/likes/{questionId}")
    public ResponseEntity <?> getAllAnswersByLikes(@PathVariable("questionId") Integer questionId, HttpSession session) {

        if (session.getAttribute ( "currUser" ) == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            return new ResponseEntity <> ( answerService.getAllAnswersByLikes ( questionId ), HttpStatus.OK );
        }

    }

    @DeleteMapping("/api/answer/{answerId}")
    public ResponseEntity <?> deleteAnswer(@PathVariable("answerId") Integer answerId, HttpSession session) {
        User loggedInUser = (User) session.getAttribute ( "currUser" );
        if (loggedInUser == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            //remaining check ser who created the question to implement
            if (!loggedInUser.getRole ().equalsIgnoreCase ( "admin" )) {

                return new ResponseEntity <> ( "You do not have rights to delete this answer.", HttpStatus.UNAUTHORIZED );
            } else {
                return new ResponseEntity <> ( " Answer with answerId " + answerService.findUserIdfromAnswer ( answerId ) + " deleted successfully.", HttpStatus.OK );
            }
        }
    }
}