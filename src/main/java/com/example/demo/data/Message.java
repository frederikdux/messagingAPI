package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.Name;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    private Long id;
    private String text;
    private String LED_MAP;

    private Boolean seen;

    private String timestamp;


    public Message(){
    }

    public Message(String text, String LED_MAP) {
        this.id = id;
        this.text = text;
        this.LED_MAP = LED_MAP;
        this.seen = false;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        this.timestamp = timeStamp.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getLED_MAP() {
        return LED_MAP;
    }
}
