package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

    @Id
    private int id;
    private String content;
    private Date date;
    private int user_id;
    private int answer_id;
    private Date modifiedOn;

    public Comment() { }

    public Comment(int id, String content, Date date, int user_id, int answer_id, Date modifiedOn) {
        super();
        this.id = id;
        this.content = content;
        this.date = date;
        this.user_id = user_id;
        this.answer_id = answer_id;
        this.modifiedOn = modifiedOn;
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

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
