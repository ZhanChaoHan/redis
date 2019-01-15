package com.jachs.redis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendMessAge {
	@Autowired
	private  KafkaTemplate kafkaTemplate;
	
	@RequestMapping("/send")
	public String send() {
		
		kafkaTemplate.send("test1",new Date().getTime()+"");
		return "";
	}
}
