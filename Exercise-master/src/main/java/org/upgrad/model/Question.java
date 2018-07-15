package org.upgrad.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Question {

    @Id
    private int id;
    private String content;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set <Category> categories;

    public Question() {
    }

    public Question(int id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;

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
