package com.jachs.redis.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Process {
	@KafkaListener(topics = "test1")
	public void processMessage(String content) {
		System.out.println(content);
	}
}
