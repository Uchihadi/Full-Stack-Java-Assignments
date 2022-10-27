package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.*;
import com.springbootNurhadi.springsg.Response.GeneralResponse;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.model.UserModel;
import com.springbootNurhadi.springsg.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// 1) Register (Name, Email, Mobile, Address, Password) from React to Spring Boot
// 2) Login with Email and Password from React to Spring Boot. If User exist, return User Details; else throw error
// 3) Update User from React
// 4) Delete User from React
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("Register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        UserResponse Response = userService.register(userRequest);

        if (Response != null) {
            Response.setMessage("User Registered Successfully");
            return ResponseEntity.ok(Response.getUserModel());
        } else {
            UserResponse Res = new UserResponse();
            Res.setMessage("User Failed to Register");
            return ResponseEntity.badRequest().body(Res);
        }
    }

    @PostMapping ("UserLogin") // If Null, still returns as Response 200 but empty
    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest) {
        UserResponse Response = userService.verifyEmailAndPassword(userRequest);

        if (Response != null) {
            Response.setMessage("Welcome Back, Login is Successful");
            return ResponseEntity.ok(Response.getUserModel());
        } else {
            Response.setMessage("Your Login is Unsuccessful, please check your Login credentials.");
            return ResponseEntity.badRequest().body(Response);
        }
    }
    @PostMapping ("Update")
    public ResponseEntity<?> userUpdate (@RequestBody UpdateReq updateRequest) {
        UserResponse Response = userService.updateUser(updateRequest);

        if (Response != null) {
            Response.setMessage("User Updated Successfully");
            return ResponseEntity.ok(Response.getUserModel());
        } else {
            UserResponse Res = new UserResponse();
            Res.setMessage("User Failed to Update");
            return ResponseEntity.badRequest().body(Res);
        }
    }

    @PostMapping ("Delete")
    public ResponseEntity<?> userDelete (@RequestBody UpdateReq updateRequest) {
        UserResponse Response = userService.deleteUser(updateRequest);

        if (Response != null) {
            Response.setMessage("User Deleted Successfully");
            return ResponseEntity.ok(Response.getUserModel());
        } else {
            UserResponse Res = new UserResponse();
            Res.setMessage("User Failed to Delete");
            return ResponseEntity.badRequest().body(Res);
        }
    }
}