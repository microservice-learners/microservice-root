package com.edureka.ms.catalogueservice.controller;


import com.edureka.ms.catalogueservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "product")
public class ProductController {

    //Add the N-1 Layer
    @Autowired
    ProductService productService;

    @PostMapping
    //
    // POST http://localhost:8081/product
    //  {
    //      "name":"Edureka"
    //      "description":"Edureka Description"
    //  }
    public ResponseEntity<Boolean> save(@RequestBody ProductService.ProductDTO productDTO){
        //Implement this
        return ResponseEntity.ok().body(true);
    }

    @GetMapping
    //GET http://localhost:8081/product?name=Edureka
    public ResponseEntity<Boolean> isExists(@RequestParam String name){
        //Implement this
        return ResponseEntity.ok().body(true || false);
    }


}
