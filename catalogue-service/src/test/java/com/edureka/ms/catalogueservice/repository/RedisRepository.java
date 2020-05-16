package com.edureka.ms.catalogueservice.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class RedisRepository {

    @Test
    public void shouldPINGPONG(){
        Jedis jedis = new Jedis("localhost");
        String pong = jedis.ping();
        Assertions.assertThat(pong).isEqualTo("PONG");
    }
}
