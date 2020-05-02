package com.edureka.ms.catalogueservice.service;

import com.edureka.ms.catalogueservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(ProductDTO productDTO){
        //Write a transformer which does the transformation;
        //convert product dto into product
        //save the product using repository
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductDTO{
        String name;
        String description;
    }

}
