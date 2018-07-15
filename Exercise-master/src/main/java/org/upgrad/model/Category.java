package org.upgrad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Category {

    @Id
    private int id;
    private String title;
    private String description;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set <Question> question;

    public Category() {
    }

    public Category(int id, String title, String description) {
        super ();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set <Question> getQuestion() {
        return question;
    }

    public void setQuestion(Set <Question> question) {
        this.question = question;
    }
}
