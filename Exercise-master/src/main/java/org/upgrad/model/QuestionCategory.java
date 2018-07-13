package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionCategory {

    @Id
    private int id;
    private int question_id;
    private int category_id;

    public QuestionCategory() { }

    public QuestionCategory(int id, int question_id, int category_id) {
        super();
        this.id = id;
        this.question_id = question_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
