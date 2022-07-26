package com.springmessenger.service;

import com.springmessenger.entity.Message;
import com.springmessenger.entity.MessageCSV;
import com.springmessenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void getAllMessage() {
        System.out.println(messageRepository.findAll());
    }


//    public List<Message> getAllMessage() {
//        return messageRepository.getAllMessage();
//    }
//
//    public void createMessage(Message message) {
//        messageRepository.createMessage(message);
//    }
//
//    public void updateMessage (Message message){
//        messageRepository.updateMessage(message);
//    }
//
//    public Message getMessageById(long id) {
//        return messageRepository.getMessageById(id);
//    }
//

//    public void deleteMessage (long id){
//        messageRepository.deleteMessage(id);
//    }

    //Методы для CSV файла

//
//    public List<MessageCSV> getAll() {
//        return messageRepository.getAll();
//    }
//
//    public MessageCSV getById(long id) {
//        return messageRepository.getById(id);
//    }
//
//    public void create(String name, String text) {
//        List<MessageCSV> messageCSVS = messageRepository.getAll();
//        messageCSVS.add(new MessageCSV((messageCSVS.size() + 1), name, text));
//        messageRepository.saveToFile(messageCSVS);
//    }
//
//    public void delete(long id) {
//        List<MessageCSV> messageCSVS = messageRepository.getAll();
//        messageRepository.saveToFile(messageCSVS.stream().filter(mes -> mes.getId() != id).collect(Collectors.toList()));
//    }
//
//    public void update(long id, String text) {
//        List<MessageCSV> messageCSVS = messageRepository.getAll();
//        for (MessageCSV messageCSV : messageCSVS) {
//            if (messageCSV.getId() == id) {
//                messageCSV.setText(text);
//            }
//        }
//        messageRepository.saveToFile(messageCSVS);
//    }
}
