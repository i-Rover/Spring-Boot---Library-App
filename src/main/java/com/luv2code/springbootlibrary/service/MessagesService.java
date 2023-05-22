package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.MessageRepository;
import com.luv2code.springbootlibrary.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesService {
    private MessageRepository messageRepository;

    @Autowired
    public MessagesService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public void postMessage(Messages messageRequest, String userEmail){
        Messages message = new Messages(messageRequest.getTitle(), messageRequest.getUserEmail());
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }
}
