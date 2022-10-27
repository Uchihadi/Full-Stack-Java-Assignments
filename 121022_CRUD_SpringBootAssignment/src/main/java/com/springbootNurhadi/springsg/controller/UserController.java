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
            Res.setMessage("User Failed to Register Successfully");
            return ResponseEntity.badRequest().body(Res);
        }
    }

    @PostMapping ("UserLogin")
    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest) {
        GeneralResponse Response = new GeneralResponse();

        if (userService.validateLogin(userRequest)) {
            Response.setMessage("Welcome Back, Login is Successful");
            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
            return ResponseEntity.ok(Response);
        } else {
            Response.setMessage("Your Login is Unsuccessful, please check your Login credentials.");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping ("UserLogout")
    public ResponseEntity<?> userLogout (@RequestBody UserRequest userRequest) {
        GeneralResponse Response = new GeneralResponse();

        if (userService.validateLogout(userRequest)) {
            Response.setMessage("You have successfully logged out!");
            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
            return ResponseEntity.ok(Response);
        } else {
            Response.setMessage("Your Logout is not successful");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping ("Update")
    public ResponseEntity<?> userUpdate (@RequestBody UpdateReq updateReq) {
        GeneralResponse Response = new GeneralResponse();

        if (userService.validateUpdate(updateReq)) {
            Response.setMessage("You have successfully updated your details");
            Response.setUser(userService.getUserByEmail(updateReq.getEmail()));
            return ResponseEntity.ok(Response);
        } else {
            Response.setMessage("Your credential updates are unsuccessful");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping ("Delete")
    public ResponseEntity<?> userDelete (@RequestBody UserRequest userRequest) {
        GeneralResponse Response = new GeneralResponse();

        if (userService.validateDelete(userRequest)) {
            Response.setMessage("You have successfully deleted your credentials");
            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
            return ResponseEntity.ok(Response);
        } else {
            Response.setMessage("Your Credentials are Unsuccessful");
            return ResponseEntity.badRequest().body(Response);
        }
    }
}