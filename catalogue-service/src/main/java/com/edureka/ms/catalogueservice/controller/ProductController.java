package com.edureka.ms.catalogueservice.controller;


import com.edureka.ms.catalogueservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    //Add the N-1 Layer
    @Autowired
    ProductService productService;

    @PostMapping
    //
    //  POST http://localhost:8081/product
    //  {
    //      "name":"Edureka"
    //      "description":"Edureka Description"
    //  }
    public ResponseEntity<Boolean> save(@RequestBody ProductService.ProductDTO productDTO){
        boolean saved = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    //GET http://localhost:8081/product?name=Edureka&description=SomeDescription
    public ResponseEntity<Boolean> isExists(@RequestParam(name = "name") String value){
        boolean exists = productService.isExists(value);
        return ResponseEntity.status(HttpStatus.OK).body(exists);
    }


}
