package com.springmessenger.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springmessenger.entity.Message;
import com.springmessenger.entity.MessageCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Repository
public class MessageRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public static final String GET_ALL_MESSAGE_ENTITY = """
            select * from messages
            """;

    public static final String INSERT_MESSAGE_ENTITY = """
            insert into messages (content, chat_id, sender_user_id) 
            VALUES (?, ?, ?)
            """;

    public List<Message> getAllMessage() {
        return jdbcTemplate.query(GET_ALL_MESSAGE_ENTITY, (rs, rowNum) -> new Message(
                rs.getLong("id"),
                rs.getTimestamp("data_create_message").toLocalDateTime(),
                rs.getString("content"),
                rs.getLong("chat_id"),
                rs.getLong("sender_user_id")
        ));
    }

//    public void create(Message message) {
//        jdbcTemplate.update(INSERT_MESSAGE_ENTITY,
//                message.getContent(),
//                message.getChatId(),
//                message.getSenderUserId());
//    }

    private final Path path = Path.of("src", "main", "resources", "messages.csv");

    public void saveToFile(List<MessageCSV> messageCSVS) {
        try {
            try (Writer writer = Files.newBufferedWriter(path)) {
                var beanToCsv = new StatefulBeanToCsvBuilder<MessageCSV>(writer).build();
                beanToCsv.write(messageCSVS);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<MessageCSV> getAll() {
        List<MessageCSV> messageCSVS;
        try {
            try (Reader reader = Files.newBufferedReader(path)) {
                messageCSVS = new CsvToBeanBuilder<MessageCSV>(reader).withType(MessageCSV.class).build().parse();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messageCSVS;
    }

    public MessageCSV getById(long id) {
        return getAll().stream().filter(mes -> mes.getId() == id).findFirst().orElse(null);
    }
}
