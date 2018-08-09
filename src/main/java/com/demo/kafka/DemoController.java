package com.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.model.User;

@RestController
@RequestMapping("kafka")
/*start Zookeeper ,start kafka-server , create tpoic , start consumer to see published messages sent*/
public class DemoController {
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	String Topic = "kafka-example";
@GetMapping("/publish")
public ResponseEntity<?> publish(@RequestParam("message") String message)
{
	kafkaTemplate.send(Topic,new User(message,"technology",20000L));
	return new ResponseEntity<String>("Message Published successfully", HttpStatus.OK);
}
}
