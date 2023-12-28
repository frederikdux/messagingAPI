package com.example.demo.service;

import com.example.demo.data.Message;
import com.example.demo.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    public void addNewMessage(Message message) {
        messageRepository.save(message);
    }
}
