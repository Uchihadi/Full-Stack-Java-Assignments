package com.example.week6day2.controller;

import com.example.week6day2.request.AdditionRequest;
import com.example.week6day2.request.UserRequest;
import com.example.week6day2.response.GeneralResponse;
import com.example.week6day2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServices userService; //Creates Object userService from class UserServices in the Spring Boot Application; does not need to create Java way
    // Can be achieved only in UserController File

    @CrossOrigin (origins = "http://localhost:3000")
    @PostMapping("add")
    public ResponseEntity <GeneralResponse> addition(@RequestBody AdditionRequest additionRequest) { //Request Body
        int plus = userService.addition(additionRequest.getNumber1(), additionRequest.getNumber2());
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("Result is ", +plus);
        return ResponseEntity.ok(Response);
    }

    @GetMapping("message")//this end point will match /user

    public ResponseEntity<?> getMessage(){
        GeneralResponse response = new GeneralResponse();
        response.setMessage("this is for message url");
        return ResponseEntity.ok(response);//pas
//        HashMap<String ,String> obj = new HashMap<>();
//        obj.put("user","this is user");
        //return ResponseEntity.ok(obj);//passing the obj wch ll convert into json response

    }

    // Sending the Path Variable; in Order to receive the value we use the Path Variable; Dynamically sendign the variable

    @GetMapping("user/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable Integer user_id){
        GeneralResponse response = new GeneralResponse();
        response.setMessage("user id is "+user_id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("userLogin")
    public ResponseEntity<?> userlogin(@RequestBody UserRequest userRequest){

        //Array List with User Data
        GeneralResponse Response = new GeneralResponse();
        try{
            userService.validateUserLogin(userRequest.getEmail(),userRequest.getPassword());
            Response.setMessage("Login Credentials are Correct!");
            return ResponseEntity.ok(Response);
        }catch (Exception e){ //If Boolean is false from the User Services, hence it will return the Exception e
            Response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping("userRegister")
    public ResponseEntity<?> userRegister(){
        GeneralResponse response = new GeneralResponse();
        try{
            userService.createUser();
            response.setMessage("Registered successfully");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
