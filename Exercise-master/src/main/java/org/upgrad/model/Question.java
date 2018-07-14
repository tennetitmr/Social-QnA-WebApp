package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class Question {

    @Id
    private int id;
    private String content;
    private Date date;
    private int user_id;
    private User user;
    private Set <Category> categories;

    public Question() {
    }

    public Question(int id, String content, Date date, int user_id) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set <Category> getCategories() {
        return categories;
    }

    public void setCategories(Set <Category> categories) {
        this.categories = categories;
    }
}
