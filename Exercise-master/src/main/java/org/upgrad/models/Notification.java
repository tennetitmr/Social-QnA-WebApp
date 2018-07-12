package org.upgrad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Notification {

    @Id
    private int id;
    private String message;
    private Date date;
    private boolean read;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    public Notification() {
    }

    public Notification(int id, String message, Date date, boolean read, User user) {
        super ();
        this.id = id;
        this.message = message;
        this.date = date;
        this.read = read;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", message='" + message + '\'' + ", date=" + date + ", read=" + read + ", user=" + user + '}';
    }
}
