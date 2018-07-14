package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.Category;
import org.upgrad.model.User;
import org.upgrad.services.CategoryService;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {


    @Autowired
    private CategoryService categoryService;


    @PostMapping("/api/admin/category")
    public ResponseEntity <?> categoriesCreation(@RequestParam("categoryTitle") String categoryTitle, @RequestParam("description") String description, HttpSession session) {
        User currUser = (User) session.getAttribute ( "currUser" );
        if (currUser == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {

            if (currUser.getRole ().equals ( "admin" )) {
                int id = (int) System.currentTimeMillis () / 1000;
                Category newCategory = new Category ( id, categoryTitle, description );

                //call  service method to add new category into repository

                return new ResponseEntity <> ( newCategory.getTitle () + " category added successfully.", HttpStatus.OK );

            } else {
                return new ResponseEntity <> ( "You do not have rights to add categories.", HttpStatus.UNAUTHORIZED );
            }


        }

    }
}


