package org.upgrad.services;

import org.upgrad.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List <Category> getAllCategories();
}
