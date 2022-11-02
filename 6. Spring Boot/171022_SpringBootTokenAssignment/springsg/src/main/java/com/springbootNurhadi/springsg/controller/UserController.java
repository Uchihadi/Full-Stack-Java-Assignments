package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateRequest;
import com.springbootNurhadi.springsg.Response.GeneralResponse;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.model.UserModel;
import com.springbootNurhadi.springsg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// 1) If Login is successful then generate Token against User
// 2) Token Authentication using Interceptor
// 3) Clear Token during Logout

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("user")
//    //Matches with http://localhost:8080/user
//    public ResponseEntity<?> getUser() {
//        GeneralResponse Response = new GeneralResponse("Hi, How Are You");
//    //Response.setMyName("User 1");
//        return ResponseEntity.ok(Response); //Passing off the Object
//    }
//
//
//    @GetMapping("message")
//    //Matches with http://localhost:8080/message
//    public ResponseEntity<?> getMessage() {
//        GeneralResponse Response = new GeneralResponse("Hello World");
//        Response.setMessage("This is My Message");
//        // HashMap<String, String> Obj = new HashMap<>(); // If it is a small Object then use HashMap
//        // Obj.put("User", "This is Users");
//        return ResponseEntity.ok(Response); //Passing off the Object
//    }
//
//    @GetMapping("Users")
//    public ResponseEntity<?> getAllUsers() {
//        ArrayList <UserModel> users = userService.getAllUsers();
//        return ResponseEntity.ok(users.toArray());
//    }
//
//    @GetMapping("Emails")
//    public ResponseEntity<?> getAllEmails() {
//        ArrayList <String> emails = userService.getAllEmails();
//        return ResponseEntity.ok(emails.toArray());
//    }
//
//    @PostMapping("Register")
//    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.register(userRequest)) {
//            Response.setMessage("Successfully Registered!");
//            Response.setUserModel(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Registration is Invalid");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }

    @PostMapping ("user/userLogin")
    public ResponseEntity<?> userlogin (@RequestBody UserRequest userRequest) {
        try{
            UserModel user = userService.validateUserLogin (userRequest.getEmail(),userRequest.getPassword());
            return ResponseEntity.ok(user);
        }catch (Exception e){
            GeneralResponse response = new GeneralResponse();
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

//    @PostMapping ("UserLogout")
//    public ResponseEntity<?> userLogout (@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateLogout(userRequest)) {
//            Response.setMessage("You have successfully logged out!");
//            Response.setUserModel(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Logout is not successful");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @PostMapping ("Update")
//    public ResponseEntity<?> userUpdate (@RequestBody UpdateRequest updateRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateUpdate(updateRequest)) {
//            Response.setMessage("You have successfully updated your details");
//            Response.setUserModel(userService.getUserByEmail(updateRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your credential updates are unsuccessful");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @PostMapping ("Delete")
//    public ResponseEntity<?> userDelete (@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateDelete(userRequest)) {
//            Response.setMessage("You have successfully deleted your credentials");
//            Response.setUserModel(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Credentials are Unsuccessful");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }

    @Autowired
    UserRepo userRepo;
}