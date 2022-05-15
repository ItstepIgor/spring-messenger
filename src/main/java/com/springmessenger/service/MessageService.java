package com.springmessenger.service;

import com.springmessenger.entity.Bean;
import com.springmessenger.entity.Message;
import lombok.SneakyThrows;
import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {


    public List<Message> getAll() {
        System.out.println("Проверка работы2");


        try {
//            String csvFilename = "K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\country.csv";
            File csvFilename = new File("E:\\JAVA\\IdeaProjects\\spring-messenger\\messages.csv");
//            Reader reader = Files.newBufferedReader(Paths.get("E:\\JAVA\\IdeaProjects\\spring-messenger\\messages.csv"));
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFilename))) {

                System.out.println(reader);
            }

//            Reader reader = new StringReader(
//                    "name;number;date\n" +
//                            "\"Alpha\";1900;\"13-07-1922\"\n" +"
//                            "\"Beta\";1901;\"22-01-1943\"\n" +
//                            "\"Gamma\";1902;\"30-09-1978\""
//            );


//            CsvClient<Message> csvReader = new CsvClientImpl<Message>(reader, Message.class);
//            final List<Message> beans = csvReader.readBeans();

//            for (Message bean : beans) {
//                System.out.println(
//                        bean.getId() + " | " +
//                                bean.getName() + " | " +
//                                bean.getText());
//            }

//            reader.close();

//            String filename="messages.csv";
//            Path pathToFile = Paths.get(filename);
//            System.out.println(pathToFile.toAbsolutePath());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
