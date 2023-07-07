package com.jasonycode.springbootlibraryapp.controller;

import com.jasonycode.springbootlibraryapp.entity.Message;
import com.jasonycode.springbootlibraryapp.requestmodels.AdminQuestionRequest;
import com.jasonycode.springbootlibraryapp.service.MessageService;
import com.jasonycode.springbootlibraryapp.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messageService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessaage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Admin paage only.");
        }
        messageService.putMessage(adminQuestionRequest, userEmail);
    }
}
