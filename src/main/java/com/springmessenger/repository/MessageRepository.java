package com.springmessenger.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springmessenger.entity.Message;
import com.springmessenger.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MessageRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    public List<MessageEntity> getAllMessageEntity() {
        return jdbcTemplate.query("select * from messages", (rs, rowNum) -> new MessageEntity(
                rs.getLong("id"),
                rs.getTimestamp("data_create_message").toLocalDateTime(),
                rs.getString("content"),
                rs.getLong("chat_id"),
                rs.getLong("sender_user_id")
        ));
    }

    private final Path path = Path.of("src", "main", "resources", "messages.csv");

    public void saveToFile(List<Message> messages) {
        try {
            try (Writer writer = Files.newBufferedWriter(path)) {
                var beanToCsv = new StatefulBeanToCsvBuilder<Message>(writer).build();
                beanToCsv.write(messages);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


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
}
