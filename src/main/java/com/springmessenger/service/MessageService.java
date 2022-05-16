package com.springmessenger.service;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.springmessenger.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private ColumnPositionMappingStrategy columnPositionMappingStrategy;

    public List<Message> getAll() {
        List<Message> messages;

        try {
            Path path = Path.of("K:\\Java\\IdeaProjects\\test-csv-parse\\src\\main\\resources\\messages.csv");

            columnPositionMappingStrategy.setType(Message.class);

            Reader reader = Files.newBufferedReader(path);
            CsvToBean cb = new CsvToBeanBuilder(reader)
                    .withType(Message.class)
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .build();
            messages = cb.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messages;
    }
}
