package com.springmessenger.repository;

import com.springmessenger.entity.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository {

//    @Autowired
//    public JdbcTemplate jdbcTemplate;

    @Autowired
    public SessionFactory sessionFactory;

    public static final String GET_ALL_MESSAGE = """
            SELECT * FROM messages
            """;

    public static final String INSERT_MESSAGE = """
            INSERT INTO messages (content, chat_id, sender_user_id)
            VALUES (?, ?, ?)
            """;

    public static final String UPDATE_MESSAGE = """
            UPDATE messages SET content = ? WHERE id = ?
            """;
    public static final String GET_MESSAGE_BY_ID = """
            SELECT * FROM messages WHERE id = ?
            """;

    public static final String DELETE_BY_ID = """
            DELETE FROM messages WHERE id = ?
            """;


    public List<Message> findAll() {
        List<Message> messages = (List<Message>) sessionFactory.openSession().createQuery("From Message").list();
        return messages;
    }


//    методы для JDBC

//    public List<Message> getAllMessage() {
//        return jdbcTemplate.query(GET_ALL_MESSAGE, (rs, rowNum) -> new Message(
//                rs.getLong("id"),
//                rs.getTimestamp("data_create_message").toLocalDateTime(),
//                rs.getString("content"),
//                rs.getLong("chat_id"),
//                rs.getLong("sender_user_id")
//        ));
//    }

//    public void createMessage(Message message) {
//        jdbcTemplate.update(INSERT_MESSAGE,
//                message.getContent(),
//                message.getChatId(),
//                message.getSenderUserId());
//    }

//    public void updateMessage(Message message) {
//        jdbcTemplate.update(UPDATE_MESSAGE,
//                message.getContent(),
//                message.getId());
//    }

//    public Message getMessageById(long id) {
//        return jdbcTemplate.queryForObject(GET_MESSAGE_BY_ID, (rs, rowNum) -> new Message(
//                rs.getLong("id"),
//                rs.getTimestamp("data_create_message").toLocalDateTime(),
//                rs.getString("content"),
//                rs.getLong("chat_id"),
//                rs.getLong("sender_user_id")
//        ), id);
//    }

//    public void deleteMessage(long id) {
//        jdbcTemplate.update(DELETE_BY_ID, id);
//    }


    //методы для CSV файла
//
//    private final Path path = Path.of("src", "main", "resources", "messages.csv");
//
//    public void saveToFile(List<MessageCSV> messageCSVS) {
//        try {
//            try (Writer writer = Files.newBufferedWriter(path)) {
//                var beanToCsv = new StatefulBeanToCsvBuilder<MessageCSV>(writer).build();
//                beanToCsv.write(messageCSVS);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public List<MessageCSV> getAll() {
//        List<MessageCSV> messageCSVS;
//        try {
//            try (Reader reader = Files.newBufferedReader(path)) {
//                messageCSVS = new CsvToBeanBuilder<MessageCSV>(reader).withType(MessageCSV.class).build().parse();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return messageCSVS;
//    }
//
//    public MessageCSV getById(long id) {
//        return getAll().stream().filter(mes -> mes.getId() == id).findFirst().orElse(null);
//    }
}
