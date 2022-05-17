package com.springmessenger.service;

import com.opencsv.bean.*;
import com.springmessenger.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MessageService {

//    @Autowired
//    private ColumnPositionMappingStrategy columnPositionMappingStrategy;

    public List<Message> getAll() {
        List<Message> messages;

        try {
            Path path = Path.of("K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv");
            Reader reader = Files.newBufferedReader(path);

            messages = new CsvToBeanBuilder(reader)
                    .withType(Message.class).build().parse();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public Message getById(long id) {
        return getAll().stream().filter(mes -> mes.getId() == id).findFirst().orElse(null);
    }

    public void create(String name, String text) {
        Path path = Path.of("K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv");


        List<Message> messages = getAll();
        long id = messages.size() + 1;
        messages.add(new Message(id, name, text));

        try (Writer writer = new FileWriter(path.toString())) {
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(messages);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
