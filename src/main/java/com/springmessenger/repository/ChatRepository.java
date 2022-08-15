package com.springmessenger.repository;

import com.springmessenger.entity.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {

    public final SessionFactory sessionFactory;

    public ChatRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Chat findById(long id) {
        Session session = sessionFactory.openSession();
        Chat chat = session.get(Chat.class, id);
        session.close();
        return chat;
    }
}
