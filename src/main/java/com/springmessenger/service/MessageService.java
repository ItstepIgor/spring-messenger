package com.springmessenger.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.springmessenger.entity.Message;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {


    @SneakyThrows
    public List<Message> getAll() {
        System.out.println("Проверка работы2");



//        try (CSVReader reader = new CSVReader(new FileReader("K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv"))) {
//            List<String[]> r = reader.readAll();
//            r.forEach(x -> System.out.println(Arrays.toString(x)));
//        }

        try {
            String fileName = "K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv";

            List<Message> beans = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Message.class)
                    .build()
                    .parse();

            beans.forEach(System.out::println);


//            Reader reader = Files.newBufferedReader(Paths.get("K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv"));
//            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
//                    .withType(Message.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//
//            for (Message message : (Iterable<Message>) csvToBean) {
//                System.out.println(message);
////                System.out.println("ID: " + message.getId());
////                System.out.println("Name: " + message.getName());
////                System.out.println("Text: " + message.getText());
//            }
//
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
