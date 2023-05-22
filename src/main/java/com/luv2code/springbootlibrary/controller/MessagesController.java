package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.entity.Messages;
import com.luv2code.springbootlibrary.service.MessagesService;
import com.luv2code.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/messages")
public class MessagesController {
    private MessagesService messagesService;
    @Autowired
    public MessagesController(MessagesService messagesService){
        this.messagesService = messagesService;
    }
    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value="Authorization") String token,
                            @RequestBody Messages messageRequest){
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }
}
