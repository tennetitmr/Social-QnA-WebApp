package org.upgrad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String userName;
    private String email;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List <Question> questions;

    @OneToMany
    @JsonIgnore
    private List <Answer> answers;

    public User() {
    }

    public User(String userName) {
        super ();
        this.userName = userName;
    }

    public User(int id, String userName, String email, String password, String role) {
        super ();
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List <Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List <Question> questions) {
        this.questions = questions;
    }
}
