package com.rn.study.ai.mcpclient.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Mono<String> chat(String question) {
        return Mono.fromCallable(() -> chatClient
                .prompt()
                .user(question)
                .call()
                .content())
                .subscribeOn(Schedulers.boundedElastic());
    }
}
