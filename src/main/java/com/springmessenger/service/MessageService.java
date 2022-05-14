package com.springmessenger.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
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


    public List<Message> getAll() {
        System.out.println("Проверка работы2");


        try {
//            String csvFilename = "K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\country.csv";
//            String csvFilename = "K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv";
            Reader reader = Files.newBufferedReader(Paths.get("K:\\Java\\IdeaProjects\\spring-messenger\\src\\main\\resources\\messages.csv"));

            String[] columns = {"id", "name", "text"};

            // create a mapping strategy
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Message.class);
            strategy.setColumnMapping(columns);

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();



            for (Message user : (Iterable<Message>) csvToBean) {
                System.out.println(user);
            }

//            FileReader filereader = new FileReader(file);
//// create csvReader object and skip first Line
//            CSVReader csvReader = new CSVReaderBuilder(filereader)
//                    .withSkipLines(1)
//                    .build();
//            List<String[]> allData = csvReader.readAll();
//// print Data
//            for (String[] row : allData) {
//                for (String cell : row) {
//                    System.out.print(cell + " ");
//                }
//                System.out.println();
//            }

            reader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

//    @SuppressWarnings({"rawtypes", "unchecked"})
//    private static ColumnPositionMappingStrategy setColumMapping()
//    {
//        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
//        strategy.setType(Message.class);
//        String[] columns = new String[] {"id", "name", "text"};
//        strategy.setColumnMapping(columns);
//        return strategy;
//    }

}
