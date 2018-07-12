package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Likes {

    @Id
    private int id;
    private int user_id;
    private int answer_id;

    public Likes() { }

    public Likes(int id, int user_id, int answer_id) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.answer_id = answer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
