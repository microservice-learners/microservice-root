package com.edureka.ms.orderservice.controller;

import com.edureka.ms.orderservice.repository.OrderRepository;
import com.edureka.ms.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity saveOrder(@RequestBody OrderService.OrderDTO orderDTO){
        /*if(orderDTO!=null && orderDTO.getName().equals("DummyName")){
            if(!orderDTO.isValid()){
                throw new ContractFailed();
            }else{
                return ResponseEntity.status(1000).body(true);
            }
        }else{
            if(orderDTO == null){
                throw new ContractFailed();
            }
        }*/
        //1. The request lands here
        //2. OrderDTO is completely deseiriazed
        //Skip from here.....
        boolean saved = orderService.saveOrder(orderDTO);
        if(saved){
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }else{
            throw new OrderNotCreatedException();
        }
    }

    @GetMapping
    public ResponseEntity isExist(@RequestParam(name = "name") String name){
        boolean exists = orderService.isExists(name);
        return ResponseEntity.status(HttpStatus.OK).body(exists);
    }

    private static class OrderNotCreatedException extends RuntimeException {
    }

    public static class ContractFailed extends RuntimeException {
    }
}
