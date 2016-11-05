package com.blog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message implements Serializable {


    private Integer id;

    @Column(name = "TEXT")
    private String text;

    private String readableTimeForm;

    // TODO: Delete one time field and db table row.
    @Column(name = "DATE")
    private Date date;

    @Column(name = "TIME")
    private Date time;

    private User user;

    public Message() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReadableTimeForm() {
        return readableTimeForm;
    }

    public void setReadableTimeForm(String readableTimeForm) {
        this.readableTimeForm = readableTimeForm;
    }
}
