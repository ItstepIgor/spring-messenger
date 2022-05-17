package com.springmessenger.service;

import com.opencsv.bean.*;
import com.springmessenger.entity.Message;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    //    @Autowired
//    private ColumnPositionMappingStrategy columnPositionMappingStrategy;


    public List<Message> getAll() {
        List<Message> messages;

        try {
            URL resource = getClass().getClassLoader().getResource("messages.csv");
            File file = Paths.get(resource.toURI()).toFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                messages = new CsvToBeanBuilder(reader)
                        .withType(Message.class).build().parse();
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
//        Path path = Path.of("E:\\JAVA\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv");
        try {
            URL resource = getClass().getClassLoader().getResource("messages.csv");
            File file = Paths.get(resource.toURI()).toFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
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
