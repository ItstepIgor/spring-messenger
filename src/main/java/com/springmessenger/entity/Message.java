package com.springmessenger.entity;


import com.opencsv.bean.CsvBindByName;

public class Message {
    @CsvBindByName
    private long id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String text;

    public Message(long id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Message() {
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
