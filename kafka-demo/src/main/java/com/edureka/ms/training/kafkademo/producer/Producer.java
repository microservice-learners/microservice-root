package com.edureka.ms.training.kafkademo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {
    //Kafka template to send async message to kafka
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String payload){
        kafkaTemplate.send("helloworld.t", payload);

    }
}
