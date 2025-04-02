package com.rn.study.ai.mcpclient.controller;

import com.rn.study.ai.mcpclient.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ChatController {
    private final ChatService chatServic;

    public ChatController(ChatService chatServic) {
        this.chatServic = chatServic;
    }

    @PostMapping("/chat")
    public Mono<String> chat(@RequestBody ChatRequest chatRequest) {
        return chatServic.chat(chatRequest.question);
    }

    record ChatRequest(String question) {}

    record ChatResponse(String answer) {}
}
