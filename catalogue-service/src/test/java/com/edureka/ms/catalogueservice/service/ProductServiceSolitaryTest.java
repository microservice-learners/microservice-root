package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.model.Product;
import com.edureka.ms.catalogueservice.repository.ProductRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceSolitaryTest {


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

        Product product = new ProductService.ProductTransformer().tranform(productDTO);

        boolean saved = productService.save(productDTO);
        Assertions.assertThat(saved).isTrue();

        ArgumentCaptor<Product> captor =  ArgumentCaptor.forClass(Product.class);

        Mockito.verify(productService.productRepository, Mockito.times(1)).save(captor.capture());
        Product productReal = captor.getValue();
        Assertions.assertThat(productReal).isEqualTo(product);
    }

}