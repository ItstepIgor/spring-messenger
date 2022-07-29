package com.springmessenger.repository;

import com.springmessenger.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository {

    @Autowired
    public SessionFactory sessionFactory;

    public List<Message> findAll() {
        return (List<Message>) sessionFactory.openSession().createQuery("From Message").list();
    }

    public void save(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(message);
        transaction.commit();
        session.close();
    }

    public void update(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(message);
        transaction.commit();
        session.close();
    }

    public void delete(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(message);
        transaction.commit();
        session.close();
    }

    public Message findById(long id) {
        return sessionFactory.openSession().get(Message.class, id);
    }
}
