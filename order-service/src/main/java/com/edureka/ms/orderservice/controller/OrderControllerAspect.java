package com.edureka.ms.orderservice.controller;

import com.edureka.ms.orderservice.service.OrderService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;

@Aspect
public class OrderControllerAspect {

    //@Before("execution(* com.edureka.ms.orderservice.controller.OrderController.saveOrder(..))")
    public void checkContract(JoinPoint jp, Object object){
        OrderService.OrderDTO orderDTO = (OrderService.OrderDTO)object;
        if(orderDTO!=null && orderDTO.getName().equals("DummyName")){
            if(!orderDTO.isValid()){
                throw new OrderController.ContractFailed();
            }else{
                //Figure out a way for this
                //return ResponseEntity.status(1000).body(true);
            }
        }else{
            if(orderDTO == null){
                throw new OrderController.ContractFailed();
            }
        }
    }
}
