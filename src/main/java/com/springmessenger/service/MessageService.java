package com.springmessenger.service;

import com.opencsv.bean.*;
import com.springmessenger.entity.Message;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final Path path = Path.of("src", "main", "resources", "messages.csv");

    public List<Message> getAll() {
        List<Message> messages;
        try {
            try (Reader reader = Files.newBufferedReader(path)) {
                messages = new CsvToBeanBuilder<Message>(reader).withType(Message.class).build().parse();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public Message getById(long id) {
        return getAll().stream().filter(mes -> mes.getId() == id).findFirst().orElse(null);
    }

    public void create(String name, String text) {
        List<Message> messages = getAll();
        messages.add(new Message((messages.size() + 1), name, text));
        saveToFile(messages);
    }

    public void delete(long id) {
        List<Message> messages = getAll();
        saveToFile(messages.stream().filter(mes -> mes.getId() != id).collect(Collectors.toList()));
    }

    private void saveToFile(List<Message> messages) {
        try {
            try (Writer writer = Files.newBufferedWriter(path)) {
                var beanToCsv = new StatefulBeanToCsvBuilder<Message>(writer).build();
                beanToCsv.write(messages);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(long id, String text) {
        List<Message> messages = getAll();
        for (Message message : messages) {
            if (message.getId() == id) {
                message.setText(text);
            }
        }
        saveToFile(messages);
    }
}
