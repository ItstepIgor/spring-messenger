package com.springmessenger.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;


public class Message {
    private long id;
    private String name;
    private String text;

    public Message(long id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
