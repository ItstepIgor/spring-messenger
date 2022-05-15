package com.springmessenger.entity;

import org.csveed.annotations.CsvDate;

import java.util.Date;

public class Bean {
    private String name;
    private Long number;
    @CsvDate(format="dd-MM-yyyy")
    private Date date;

    public String getName() { return name; }
    public Long getNumber() { return number; }
    public Date getDate() { return date; }
    public void setName(String name) { this.name = name; }
    public void setNumber(Long number) { this.number = number; }
    public void setDate(Date date) { this.date = date; }
}
