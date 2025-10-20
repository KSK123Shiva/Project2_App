package com.javaexpress.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserListener {

	@KafkaListener(topics = "user-topic",groupId = "userconsumergroup")
	public void listenEvents(UserDto event) {
		log.info("User Dto {} ",event.getEmail());
		// valdation
		// send userdto to another microservices as request
		// store data userdto to mongodb
		// 
	}
	
}
