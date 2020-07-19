package com.edureka.ms.training.kafkademo;

import com.edureka.ms.training.kafkademo.consumer.Consumer;
import com.edureka.ms.training.kafkademo.producer.Producer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext

//@EmbeddedKafka(partitions = 1, topics = {"helloworld.t"})
class KafkaDemoApplicationTest {

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    @Test
    public void sendAndReceiveTest() throws InterruptedException {
        producer.sendMessage("Honkey dory");
        consumer.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS);
        Assertions.assertThat(consumer.getCountDownLatch().getCount()).isEqualTo(0);
    }

}