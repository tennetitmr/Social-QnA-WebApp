package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Integer> {

    @Query(nativeQuery = true, value = "select * from  category")
    List <Category> getAllCategories();
}
