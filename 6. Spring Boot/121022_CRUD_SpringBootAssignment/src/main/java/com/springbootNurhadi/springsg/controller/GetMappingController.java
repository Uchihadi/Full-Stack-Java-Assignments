package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Response.GeneralResponse;
import com.springbootNurhadi.springsg.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetMappingController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("user")
    public ResponseEntity<?> getUser() {
        GeneralResponse Response = new GeneralResponse("Hi, How Are You");
        return ResponseEntity.ok(Response); //Passing off the Object
    }

    @GetMapping("message")
    public ResponseEntity<?> getMessage() {
        GeneralResponse Response = new GeneralResponse("Hello World");
        Response.setMessage("This is My Message");
        return ResponseEntity.ok(Response); //Passing off the Object
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        ArrayList<UserModel> users = (ArrayList<UserModel>) userRepo.findAll();
        return ResponseEntity.ok(users.toArray());
    }
}
