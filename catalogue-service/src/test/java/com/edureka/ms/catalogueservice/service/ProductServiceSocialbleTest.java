package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.model.Product;
import com.edureka.ms.catalogueservice.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceSocialbleTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveProductDTO(){
        ProductService.ProductDTO productDTO = ProductService.ProductDTO.builder()
                .name("Edureka")
                .description("Edureka Edureka")
                .build();

        productService.save(productDTO); //some record will be inserted into db

        Optional<Product> byName = productRepository.findByName(productDTO.getName());
        Assertions.assertThat(byName).isNotNull();
        //Additional verification


    }

}