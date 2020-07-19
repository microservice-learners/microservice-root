package com.edureka.ms.training.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Consumer {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(topics ="helloworld.t")
    public void receive(String payload){
        System.out.println("Sanjeev  >" + payload);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch(){
        return countDownLatch;
    }
}
