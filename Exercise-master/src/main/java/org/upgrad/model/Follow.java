package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Follow {

    @Id
    private int id;
    private int user_id;
    private int category_id;

    public Follow() { }

    public Follow(int id, int user_id, int category_id) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.category_id = category_id;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
