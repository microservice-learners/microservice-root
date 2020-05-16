package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.model.Product;
import com.edureka.ms.catalogueservice.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Jedis jedis;

    public boolean save(ProductDTO productDTO){
        //BDO - by-passed
        Product product = new ProductTransformer().tranform(productDTO);
        //Save at both cache and database
        //invalidate the cache for the key and save in db
        productRepository.save(product);
        return true;
    }

    public Optional<ProductDTO> get(String name) throws JsonProcessingException {
        String value = jedis.get(name);
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDTO productDTO = objectMapper.readValue(value, ProductDTO.class);
        if(productDTO.isValid()){
            return Optional.of(productDTO);
        }else{
            Optional<Product> byName = productRepository.findByName(name);
            ProductDTO tranformed = new ProductTransformer().tranform(byName.get());
            jedis.set(byName.get().getName(), new ObjectMapper().writeValueAsString(tranformed));
            return  Optional.of(tranformed);
        }
    }

    public boolean isExists(String name){
        return productRepository.findByName(name).isPresent();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ProductDTO{
        String name;
        String description;

        public boolean isValid() {
            return false;
        }
    }

    public static class ProductTransformer {
        public Product tranform(ProductDTO productDTO) {
            return Product.builder()
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .build();
        }

        public ProductDTO tranform(Product product) {
            return ProductDTO.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .build();
        }
    }
}
