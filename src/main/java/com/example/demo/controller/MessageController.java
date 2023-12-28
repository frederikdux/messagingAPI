package com.example.demo.controller;

import com.example.demo.data.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/messagingApi")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }

    @PostMapping("/message")
    @ResponseBody
    public ResponseEntity createMessage(@RequestBody String text, @RequestBody String LED_Map){
        messageService.addNewMessage(new Message(text, LED_Map));
        System.out.println("Message created: text: " + text + "   LED_Map: "+ LED_Map);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping
    public void registeredNewMessage(@RequestBody Message message){
    }
}
