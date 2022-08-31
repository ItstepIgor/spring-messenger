package com.springmessenger.repository;

import com.springmessenger.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MessageRepository {

    public final SessionFactory sessionFactory;

    public MessageRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //запрос с использованием Criteria API
    public List<Message> findAll() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);
        Root<Message> messageRoot = query.from(Message.class);
        query.select(messageRoot);
        return sessionFactory.openSession().createQuery(query).list();
//        return (List<Message>) sessionFactory.openSession().createQuery("From Message").list();
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
        Session session = sessionFactory.openSession();
        Message message = session.get(Message.class, id);
        //todo что бы работало закрытие сесии нужно ставить FetchType.EAGER в Message
//        session.close();

        return message;
    }
}
