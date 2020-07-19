package com.edureka.ms.training.sessionserver.controller;

import com.edureka.ms.training.sessionserver.service.SlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping(path = "distributed")
//http://localhost:8084/distributed/session
public class DistributedController {


    @Autowired
    SlowService slowService;

    @GetMapping(path = "cache")
    public ResponseEntity getSlow(@RequestParam(name = "key") String key){
        String someValue = slowService.slowMethod(key);
        return ResponseEntity.status(HttpStatus.OK).body(someValue);
    }

    @GetMapping(path = "session")
    public ResponseEntity<String> session(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uuid");
        if(uuid == null){
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uuid", uuid);
        return ResponseEntity.ok(uuid.toString());
    }
}
