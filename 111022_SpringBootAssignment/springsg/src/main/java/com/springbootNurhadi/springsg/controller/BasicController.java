package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    // [UserController] Autowired: Creates Object userService from class UserServices in the Spring Boot Application;
    @Autowired
    UserService userService;

    @GetMapping("user") // http://localhost:8090/user
    public ResponseEntity<?> getUser() {
        UserResponse Response = new UserResponse("Hi, How Are You?");
        return ResponseEntity.ok(Response); //Passing off the Object
    }


    @GetMapping("message") // http://localhost:8090/message
    public ResponseEntity<?> getMessage() {
        UserResponse Response = new UserResponse("Hello World");
        Response.setMessage("This is My Message");
        return ResponseEntity.ok(Response); //Passing off the Object

    }

    @PostMapping("addition")
    public ResponseEntity<?> addition (@RequestBody UserRequest userRequest){
        int addition  = userRequest.getNum1()+userRequest.getNum2();
        UserResponse Response = new UserResponse();
        Response.setMessage("The result of addition between two numbers are: "+addition);
        return ResponseEntity.ok(Response);
    }

}
