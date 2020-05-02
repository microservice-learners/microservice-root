package com.edureka.ms.catalogueservice.repository;

import com.edureka.ms.catalogueservice.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveAProduct(){
        Product product = Product.builder()
                .name("Some Name")
                .description("Some Description")
                .build();

        productRepository.save(product);

        List<Product> allProduct = productRepository.findAll();
        Optional<Product> firstProduct = allProduct.stream().findFirst();
        Assertions.assertThat(firstProduct.isPresent()).isTrue();
        Assertions.assertThat(firstProduct.get()).isEqualTo(product);

    }

    @Test
    public void shouldSaveManyProduct(){
        Product firstProduct = Product.builder()
                .name("Some Name")
                .description("Some Description")
                .build();

        Product secondProduct = Product.builder()
                .name("Some Name")
                .description("Some Description")
                .build();

        productRepository.saveAll(Arrays.asList(firstProduct, secondProduct));

        List<Product> all = productRepository.findAll();

        Assertions.assertThat(all).size().isEqualTo(2);

    }

    @Test
    public void shouldSearchByName(){
        Product firstProduct = Product.builder()
                .name("Some Name")
                .description("Some Description")
                .build();

        productRepository.save(firstProduct);

        Optional<Product> byName = productRepository.findByName(firstProduct.getName());

        Assertions.assertThat(byName).isNotEmpty();
        Assertions.assertThat(byName.get()).isEqualTo(firstProduct);
    }

}