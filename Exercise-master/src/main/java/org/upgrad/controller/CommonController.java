package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.services.CategoryService;

@RestController
public class CommonController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories/all")
    public ResponseEntity <?> getAllCategories() {
        return new ResponseEntity <> ( categoryService.getAllCategories (), HttpStatus.OK );

    }

}

