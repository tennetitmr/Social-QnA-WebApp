package org.upgrad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Answer {

    @Id
    private int id;
    private String ans;
    private Date date = new Date();
    private int user_id;
    private int question_id;
    @Column(name = "modifiedon")
    private Date modified_on = new Date();

    public Answer() {}

    public Answer(int id, String ans, Date date, int user_id, int question_id, Date modified_on) {
        this.id = id;
        this.ans = ans;
        this.date = date;
        this.user_id = user_id;
        this.question_id = question_id;
        this.modified_on = modified_on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
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

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Date getModifiedOn() {
        return modified_on;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modified_on = modified_on;
    }
}
