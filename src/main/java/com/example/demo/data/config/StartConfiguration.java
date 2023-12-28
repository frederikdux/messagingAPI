package com.example.demo.data.config;

import com.example.demo.data.Message;
import com.example.demo.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class StartConfiguration {
    @Autowired
    MessageRepository messageRepository;

    @Bean
    CommandLineRunner commandLineRunner(MessageRepository messageRepository){
        return args -> {
            Message message = new Message("Das ist ein Test", "0110001010");
            messageRepository.save(message);
        };
    }
}
