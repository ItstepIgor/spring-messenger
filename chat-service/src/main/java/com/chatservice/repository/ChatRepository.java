package com.chatservice.repository;

import com.chatservice.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
//
//    public final SessionFactory sessionFactory;
//
//    public ChatRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public Chat findById(long id) {
//        Session session = sessionFactory.openSession();
//        Chat chat = session.get(Chat.class, id);
//        session.close();
//        return chat;
//    }
}
