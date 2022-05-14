package com.springmessenger.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Message {
    @CsvBindByName
    private long id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String text;
}
