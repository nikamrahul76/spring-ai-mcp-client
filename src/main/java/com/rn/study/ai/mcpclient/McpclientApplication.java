package com.rn.study.ai.mcpclient;

import org.springframework.ai.autoconfigure.mcp.client.SseHttpClientTransportAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SseHttpClientTransportAutoConfiguration.class)
public class McpclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpclientApplication.class, args);
	}

}
