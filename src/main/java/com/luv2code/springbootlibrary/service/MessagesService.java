package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.MessageRepository;
import com.luv2code.springbootlibrary.entity.Messages;
import com.luv2code.springbootlibrary.requestmodels.AdminQuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MessagesService {
    private MessageRepository messageRepository;

    @Autowired
    public MessagesService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public void postMessage(Messages messageRequest, String userEmail){
        Messages message = new Messages(messageRequest.getTitle(), messageRequest.getUserEmail(), messageRequest.getClosed());
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail)throws Exception{
        Optional<Messages> message = messageRepository.findById(adminQuestionRequest.getId());
        if(!message.isPresent()){
            throw new Exception("Message is not found");
        }
        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getResponse());
        message.get().setClosed(true);
        messageRepository.save(message.get());
    }
}
