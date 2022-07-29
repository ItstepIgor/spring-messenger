package com.springmessenger.repository;

import com.springmessenger.entity.Chat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {

    @Autowired
    public SessionFactory sessionFactory;

    public Chat findById(long id) {
        return sessionFactory.openSession().get(Chat.class, id);
    }
}
