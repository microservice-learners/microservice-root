package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.model.Product;
import com.edureka.ms.catalogueservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean save(ProductDTO productDTO){
        //BDO - by-passed
        Product product = new ProductTransformer().tranform(productDTO);
        productRepository.save(product);
        return true;
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
    }

    public static class ProductTransformer {
        public Product tranform(ProductDTO productDTO) {
            return Product.builder()
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .build();
        }
    }
}
