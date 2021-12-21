package com.example;

import java.sql.Date;

public class ToDo {

    private String text;
    private boolean done = false;
    private Date date;

    public ToDo(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }
}
