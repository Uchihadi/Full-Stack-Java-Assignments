package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Request.*;
import com.springbootNurhadi.springsg.Response.GeneralResponse;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.model.EmailList;
import com.springbootNurhadi.springsg.model.UserList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController { // Returning in JSON Format for all the classes declared below as well
    @GetMapping("user") //Matches with http://localhost:8080/user
    public ResponseEntity<?> getUser() {
        GeneralResponse Response = new GeneralResponse("Hi, How Are You");
//        Response.setMyName("User 1");
        return ResponseEntity.ok(Response); //Passing off the Object
    }
    // ResponseEntity <GeneralResponse> ---> Only in GeneralResponse
    // ResponseEntity <?> --> It can be anything
    // ResponseEntity.ok() --> Success Response with 200 Status Codes
    // ResponseEntity.badRequest().body() --> Failure Response with 400 Status Codes

    @GetMapping("message") //Matches with http://localhost:8080/message
    public ResponseEntity<?> getMessage() {
        GeneralResponse Response = new GeneralResponse("Hello World");
        Response.setMessage("This is My Message");
//        HashMap<String, String> Obj = new HashMap<>(); // If it is a small Object then use HashMap
//        Obj.put("User", "This is Users");
        return ResponseEntity.ok(Response); //Passing off the Object

    }

    @PostMapping("addition")
    public ResponseEntity<?> addition (@RequestBody AdditionRequest additionRequest){
        int plus  = additionRequest.getNum1()+additionRequest.getNum2();
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("The result of addition between two numbers are: "+plus);
        return ResponseEntity.ok(Response);
    }

//    @PostMapping("userLogin")
//    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest){
//        GeneralResponse Response = new GeneralResponse();
//        if (userRequest.getEmail().equals("Admin@gmail.com")
//                && userRequest.getPassword().equals("Admin")) {
//            Response.setMessage("Correct Email & Password");
//            return ResponseEntity.ok(Response); //Send 200 Status Code --> Approved
//        } else {
//            Response.setMessage("Please provide proper Email & Password");
//            return ResponseEntity.badRequest().body(Response); // 400 Status Code (Reject)
//        }
//    }

    @PostMapping("subtraction")
    public ResponseEntity<?> subtraction (@RequestBody SubtractionRequest subtractionRequest){
        int sub  = subtractionRequest.getSub1() - subtractionRequest.getSub2();
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("The result of subtraction between two numbers are:  "+sub);
        return ResponseEntity.ok(Response);
    }

    @PostMapping("multiplication")
    public ResponseEntity<?> multiplication (@RequestBody MultiplyRequest multiplyRequest) {
        int multiply = multiplyRequest.getMulti1() * multiplyRequest.getMulti2();
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("The result of multiplication between two numbers are: " + multiply);
        return ResponseEntity.ok(Response);
    }

    @PostMapping("division")
    public ResponseEntity<?> division (@RequestBody DivisionRequest divisionRequest) {
        int divide = divisionRequest.getDiv1() / divisionRequest.getDiv2();
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("The result of division between two numbers are: " + divide);
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
}