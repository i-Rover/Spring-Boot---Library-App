package com.luv2code.springbootlibrary.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="messages")
@Data
public class Messages {
    public Messages(){}

    public Messages(String title, String question, boolean closed){
        this.title = title;
        this.question = question;
        this.closed = closed;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="title")
    private String title;
    @Column(name="question")
    private String question;
    @Column(name="admin_email")
    private String adminEmail;
    @Column(name="response")
    private String response;
    @Column(name="closed")
    private Boolean closed;
}
