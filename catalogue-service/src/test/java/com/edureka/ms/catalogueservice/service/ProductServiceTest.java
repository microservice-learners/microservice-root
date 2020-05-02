package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.repository.ProductRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {


    ProductService productService;

    @BeforeEach
    public void before(){
        productService = new ProductService();
        productService.productRepository = Mockito.mock(ProductRepository.class);
    }


    @Test
    public void shouldSaveAProductDTO(){
        ProductService.ProductDTO productDTO = ProductService.ProductDTO.builder()
                .name("Edureka")
                .description("Edureka Description")
                .build();

        boolean saved = productService.save(productDTO);
        Assertions.assertThat(saved).isTrue();
        Mockito.verify(productService.productRepository, Mockito.times(1)).save(Mockito.any());
        //TODO - Use captor to capture the argument - in this you would get the handle of Product

        //Assert that product
    }

}