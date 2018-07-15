package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.services.QuestionService;

import javax.servlet.http.HttpSession;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/api/question/all/{categoryId}")
    public ResponseEntity <?> getAllQuestionsByCategory(@PathVariable("categoryId") Integer categoryId, HttpSession session) {

        if (session.getAttribute ( "currUser" ) == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {

            return new ResponseEntity <> ( questionService.getAllQuestionsByCategory ( categoryId ), HttpStatus.OK );

        }

    }

}