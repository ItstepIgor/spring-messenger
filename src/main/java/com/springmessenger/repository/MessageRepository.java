package com.springmessenger.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springmessenger.entity.Message;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Repository
public class MessageRepository {


    //todo посмотреть нужно ли делать в других коммитах переменные и убирать вложенный try
    private static final String MESSAGES_FILE_NAME = "messages.csv";
    private static final Path PATH;

    static {
        try {
            PATH = new ClassPathResource(MESSAGES_FILE_NAME).getFile().toPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private final Path path = Path.of("src", "main", "resources", "messages.csv");

    public void saveToFile(List<Message> messages) {
        try (Writer writer = Files.newBufferedWriter(PATH)) {
            var beanToCsv = new StatefulBeanToCsvBuilder<Message>(writer).build();
            beanToCsv.write(messages);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public List<Message> getAll() {
        List<Message> messages;
        try (Reader reader = Files.newBufferedReader(PATH)) {
            messages = new CsvToBeanBuilder<Message>(reader).withType(Message.class).build().parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public Message getById(long id) {
        return getAll().stream().filter(mes -> mes.getId() == id).findFirst().orElse(null);
    }
}
