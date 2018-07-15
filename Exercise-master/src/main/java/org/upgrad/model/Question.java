package org.upgrad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {

    @Id
    @Column(insertable=false,updatable = false)
    private int id;
    private String content;
    private Date date;
    @Column(insertable=false,updatable = false)
    private int user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Question() {}

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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
