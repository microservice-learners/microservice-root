package com.edureka.spring.e2etest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTags;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest

/**
 * Stage environment - all of the four services would be up and running
 * 20 E2E test
 */
public class E2ETest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void souldTestE2EOrderCreation(){
        //Create the product
        //restTemplate.postForEntity("http://localhost:8000/product-servcie/product",,)

        //Check if the product exists

        //Create the order

        //Verify the order creation
    }
}
