package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.*;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.model.EmailList;
import com.springbootNurhadi.springsg.model.UserList;
import com.springbootNurhadi.springsg.model.UserModel;
import com.springbootNurhadi.springsg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Create an API with 2 Parameters (Email, Password)
// Email and Password Validation --> Return Success Response / Failure Response
@RestController
public class UserController {

    // [UserController] Autowired: Creates Object userService from class UserServices in the Spring Boot Application;
    @Autowired
    UserService userService;
    UserRepo userRepo;
    UserModel userModel;
    UserList userList;

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
    public ResponseEntity<?> addition (@RequestBody AdditionRequest additionRequest){
        int plus  = additionRequest.getNum1()+additionRequest.getNum2();
        UserResponse Response = new UserResponse();
        Response.setMessage("The result of addition between two numbers are: "+plus);
        return ResponseEntity.ok(Response);
    }


    @PostMapping("userLogin")
    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest){
        ArrayList<EmailList> EmailListArray = new ArrayList<EmailList>();
        EmailList User1 = new EmailList("jack.rackham@gmail.com", "jackrackham12");
        EmailList User2 = new EmailList("haytham.kenway@gmail.com", "haythamkenway22");
        EmailList User3 = new EmailList("arno.dorian@gmail.com", "arnodorian92");
        EmailList User4 = new EmailList("shay.cormac@gmail.com", "shaycormac29");
        EmailList User5 = new EmailList("jacob.frye@gmail.com", "jacobfrye@london");

        EmailListArray.add(User1);
        EmailListArray.add(User2);
        EmailListArray.add(User3);
        EmailListArray.add(User4);
        EmailListArray.add(User5);

        UserResponse Response = new UserResponse();
        if(userRequest.getPassword().equals(EmailListArray.get(0).getPassword()) &&
        userRequest.getEmail().equals(EmailListArray.get(0).getEmail())){
            Response.setMessage("Your Login is correct!");
            return ResponseEntity.ok(Response);
        } else if (userRequest.getPassword().equals(EmailListArray.get(1).getPassword()) &&
                userRequest.getEmail().equals(EmailListArray.get(1).getEmail())) {
            Response.setMessage("Your Login is correct!");
            return ResponseEntity.ok(Response);
        } else if (userRequest.getPassword().equals(EmailListArray.get(2).getPassword()) &&
                userRequest.getEmail().equals(EmailListArray.get(2).getEmail())) {
            Response.setMessage("Your Login is correct!");
            return ResponseEntity.ok(Response);
        } else if (userRequest.getPassword().equals(EmailListArray.get(3).getPassword()) &&
                userRequest.getEmail().equals(EmailListArray.get(3).getEmail())) {
            Response.setMessage("Your Login is correct!");
            return ResponseEntity.ok(Response);
        } else if (userRequest.getPassword().equals(EmailListArray.get(4).getPassword()) &&
                userRequest.getEmail().equals(EmailListArray.get(4).getEmail())) {
            Response.setMessage("Your Login is correct!");
            return ResponseEntity.ok(Response);
        } else {
            Response.setMessage("Your Login is Incorrect. Double Check your Caps Lock and Special Characters in your Password");
            return  ResponseEntity.badRequest().body(Response);
        }
    }

    @GetMapping("getUsers")
    public ArrayList<UserList> getUsers() {
        UserResponse Response = new UserResponse();
        ArrayList<UserList> UserModelListArray = new ArrayList<UserList>();
        UserList User1 = new UserList("jack.rackham96@gmail.com", "jack.rackham.96", "England");
        UserList User2 = new UserList("arno.dorian94@gmail.com", "arno.dorian.96", "France");
        UserList User3 = new UserList("haytham.kenway92@gmail.com", "haytham.kenway.92", "United States");
        UserList User4 = new UserList("shay.cormac93@gmail.com", "shay.cormac.93", "Carribean");

        UserModelListArray.add(User1);
        UserModelListArray.add(User2);
        UserModelListArray.add(User3);
        UserModelListArray.add(User4);


        if(UserModelListArray.size() != 0) {
            return UserModelListArray;
        } else {
            return null;
        }
    }

    @GetMapping("user/{user_id}")
    //GET Request --> localhost:8080/user/55 --> Returns: User ID is 55
       public ResponseEntity<?> getUser (@PathVariable Integer user_id){
       UserResponse Response = new UserResponse();
       Response.setMessage("User ID is " +user_id);
       return ResponseEntity.ok(Response);
    }

    @PostMapping("user/update/{user_id}")
    // Dynamic Configuration
    // Send raw data --> "email" : "jan@mail.com"
    // POST Request --> localhost:8080/user/update/45 --> Returns: User ID is 45 update email is email
    public ResponseEntity<?> updateUser (@PathVariable Integer user_id,
                                         @RequestBody UserRequest userRequest){
        UserResponse Response = new UserResponse();
        Response.setMessage("User ID is " +user_id+ " update email is " +userRequest.getEmail());
        return ResponseEntity.ok(Response);
    }

    @PostMapping ("userLoginParam")
    // Using Request Parameter Annotations to call Strings of Email and Password
    public ResponseEntity<?> userLogin (@RequestParam String email,
                                        @RequestParam String password){
        UserResponse Response = new UserResponse();
//        Response.setMessage(password + "--" + email);
//        return ResponseEntity.ok(Response);

        if (email.equals("") || password.equals("")){
            Response.setMessage("Your Login Credentials are Empty");
            return ResponseEntity.badRequest().body(Response);
        } else {
            Response.setMessage("Thank you for your Log In Credentials");
            return ResponseEntity.ok(Response);
        }
    }

    @GetMapping ("getOneUser/{id}")
    public ResponseEntity<?> getOneUser (@PathVariable int id){
        return userService.getOneUser(id);
    }
}