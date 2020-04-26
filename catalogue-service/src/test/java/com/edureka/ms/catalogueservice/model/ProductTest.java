package com.edureka.ms.catalogueservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void shouldUseGetterAndSetter(){
        Product product = new Product();
        product.setDescription("Some Descpription");
        product.setName("Some Name");

        product.getDescription();
        product.getName();

        new Product(1L, "Some Name", "Some Description");

        new Product();


        Product product1UsingBuilder = Product.builder()
                .description("SD")
                .name("SN")
                .build();

        System.out.println(product);
    }

}