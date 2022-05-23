package com.springmessenger.service;

import com.springmessenger.entity.Message;
import com.springmessenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Message getById(long id) {
        return messageRepository.getById(id);
    }

    public void create(String name, String text) {
        List<Message> messages = messageRepository.getAll();
        messages.add(new Message((messages.size() + 1), name, text));
        messageRepository.saveToFile(messages);
    }

    public void delete(long id) {
        List<Message> messages = messageRepository.getAll();
        messageRepository.saveToFile(messages.stream().filter(mes -> mes.getId() != id).collect(Collectors.toList()));
    }

    public void update(long id, String text) {
        List<Message> messages = messageRepository.getAll();
        for (Message message : messages) {
            if (message.getId() == id) {
                message.setText(text);
            }
        }
        messageRepository.saveToFile(messages);
    }
}
