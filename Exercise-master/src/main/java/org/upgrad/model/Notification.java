package org.upgrad.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Notification {

    @Id
    private int id;
    private int user_id;
    private String message;
    private Date date;
    private boolean read;

    public Notification() { }

    public Notification(int id, int user_id, String message, Date date, boolean read) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.message = message;
        this.date = date;
        this.read = read;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
