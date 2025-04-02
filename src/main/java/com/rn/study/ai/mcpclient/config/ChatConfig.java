package com.rn.study.ai.mcpclient.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.DefaultChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {
    @Bean
    public ChatClient chatClient(OllamaChatModel chatModel, SyncMcpToolCallbackProvider toolCallbackProvider) {
        var tools = toolCallbackProvider.getToolCallbacks();
        for (ToolCallback tool : tools) {
            System.out.println("Registered tool: " + tool.getToolDefinition().name());
        }

        return ChatClient.builder(chatModel)
                .defaultTools(tools)
                .build();
    }
}
