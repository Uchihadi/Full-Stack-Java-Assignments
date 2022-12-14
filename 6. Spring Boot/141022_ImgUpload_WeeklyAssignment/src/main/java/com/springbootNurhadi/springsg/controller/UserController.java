package com.springbootNurhadi.springsg.controller;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.*;
import com.springbootNurhadi.springsg.Response.GeneralResponse;
import com.springbootNurhadi.springsg.model.UserModel;
import com.springbootNurhadi.springsg.service.UserService;
import org.apache.catalina.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

// 1) Lombok Integration
// 2) Image Upload against the UserID
// 3) Load Image with UserID
// 4) JSON Web Token Integration and Validation

@RestController
public class UserController { // Returning in JSON Format for all the classes declared below as well

    @Autowired
    UserService userService;

    @GetMapping("user")
    //Matches with http://localhost:8080/user
    public ResponseEntity<?> getUser() {
        GeneralResponse Response = new GeneralResponse("Hi, How Are You");
    //Response.setMyName("User 1");
        return ResponseEntity.ok(Response); //Passing off the Object
    }
    // ResponseEntity <GeneralResponse> ---> Only in GeneralResponse
    // ResponseEntity <?> --> It can be anything
    // ResponseEntity.ok() --> Success Response with 200 Status Codes
    // ResponseEntity.badRequest().body() --> Failure Response with 400 Status Codes

    @GetMapping("message")
    //Matches with http://localhost:8080/message
    public ResponseEntity<?> getMessage() {
        GeneralResponse Response = new GeneralResponse("Hello World");
        Response.setMessage("This is My Message");
        // HashMap<String, String> Obj = new HashMap<>(); // If it is a small Object then use HashMap
        // Obj.put("User", "This is Users");
        return ResponseEntity.ok(Response); //Passing off the Object
    }

    @PostMapping (value = "UploadImage")
    public ResponseEntity<?> uploadImage (@RequestParam Integer id,
                                          @RequestParam MultipartFile imgfile) throws  Exception {
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage("File Upload Successful: " + imgfile.getOriginalFilename());
        try (FileOutputStream fileout
                     = new FileOutputStream("C:\\Users\\saiar\\OneDrive\\Documents\\Visual Studio 2019\\Sep Morning\\week6day5" +imgfile.getOriginalFilename())) {
            fileout.write(imgfile.getBytes());

            //Calling Service Method together with img file and id
            userService.uploadImg(imgfile.getOriginalFilename(),id);
            Response.setMessage("File Uploaded " + imgfile.getOriginalFilename());
            return ResponseEntity.ok(Response);

        } catch (Exception e) {
            Response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @GetMapping (value = "readImg/{fileName}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte [] img (@PathVariable Integer id) throws Exception {
        UserModel userModel = userService.viewUser(id);
        FileInputStream filein = new FileInputStream("C:\\Users\\saiar\\OneDrive\\Documents\\Visual Studio 2019\\Sep Morning\\week6day5" +userModel.getImg());
        return IOUtils.toByteArray(filein);
    }

//    @GetMapping("Users")
//    public ResponseEntity<?> getAllUsers() {
//        ArrayList <UserModel> users = userService.getAllUsers();
//        return ResponseEntity.ok(users.toArray());
//    }
//
//    @GetMapping("Emails")
//    public ResponseEntity<?> getAllEmails() {
//        ArrayList <UserModel> emails = userService.getAllEmails();
//        return ResponseEntity.ok(emails.toArray());
//    }
//
//    @PostMapping("Register")
//    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.register(userRequest)) {
//            Response.setMessage("Successfully Registered!");
//            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Registration is Invalid");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @PostMapping ("UserLogin")
//    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateLogin(userRequest)) {
//            Response.setMessage("Welcome Back, Login is Successful");
//            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Login is Unsuccessfull, please check your Login credentials.");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @PostMapping ("UserLogout")
//    public ResponseEntity<?> userLogout (@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateLogout(userRequest)) {
//            Response.setMessage("You have successfully logged out!");
//            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Logout is not successful");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @PostMapping ("Update")
//    public ResponseEntity<?> userUpdate (@RequestBody UserRequest userRequest) {
//        GeneralResponse Response = new GeneralResponse();
//
//        if (userService.validateUpdate(userRequest)) {
//            Response.setMessage("You have successfully updated your details");
//            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
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
//            Response.setUser(userService.getUserByEmail(userRequest.getEmail()));
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Credentials are Unsuccessful");
//            return ResponseEntity.badRequest().body(Response);
//        }
//    }

    @Autowired
    UserRepo userRepo;

//    @GetMapping
//    public ResponseEntity<?> getAllUsers() {
//        ArrayList<UserModel> users = (ArrayList<UserModel>) userRepo.findAll();
//        return ResponseEntity.ok(users.toArray());
//    }
    // Creates Object userService from class UserServices in the Spring Boot Application; does not need to create Java way
    // Can be achieved only in UserController File
//    @PostMapping("addition")
//    public ResponseEntity<?> addition (@RequestBody AdditionRequest additionRequest){
//        int plus  = additionRequest.getNum1()+additionRequest.getNum2();
//        GeneralResponse Response = new GeneralResponse();
//        Response.setMessage("The result of addition between two numbers are: "+plus);
//        return ResponseEntity.ok(Response);
//    }

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

//    @PostMapping("subtraction")
//    public ResponseEntity<?> subtraction (@RequestBody SubtractionRequest subtractionRequest){
//        int sub  = subtractionRequest.getSub1() - subtractionRequest.getSub2();
//        GeneralResponse Response = new GeneralResponse();
//        Response.setMessage("The result of subtraction between two numbers are:  "+sub);
//        return ResponseEntity.ok(Response);
//    }
//
//    @PostMapping("multiplication")
//    public ResponseEntity<?> multiplication (@RequestBody MultiplyRequest multiplyRequest) {
//        int multiply = multiplyRequest.getMulti1() * multiplyRequest.getMulti2();
//        GeneralResponse Response = new GeneralResponse();
//        Response.setMessage("The result of multiplication between two numbers are: " + multiply);
//        return ResponseEntity.ok(Response);
//    }
//
//    @PostMapping("division")
//    public ResponseEntity<?> division (@RequestBody DivisionRequest divisionRequest) {
//        int divide = divisionRequest.getDiv1() / divisionRequest.getDiv2();
//        GeneralResponse Response = new GeneralResponse();
//        Response.setMessage("The result of division between two numbers are: " + divide);
//        return ResponseEntity.ok(Response);
//    }
//
//    @PostMapping("userLogin")
//    public ResponseEntity<?> userLogin (@RequestBody UserRequest userRequest){
//        ArrayList<EmailList> EmailListArray = new ArrayList<EmailList>();
//        EmailList User1 = new EmailList("jack.rackham@gmail.com", "jackrackham12");
//        EmailList User2 = new EmailList("haytham.kenway@gmail.com", "haythamkenway22");
//        EmailList User3 = new EmailList("arno.dorian@gmail.com", "arnodorian92");
//        EmailList User4 = new EmailList("shay.cormac@gmail.com", "shaycormac29");
//        EmailList User5 = new EmailList("jacob.frye@gmail.com", "jacobfrye@london");
//
//        EmailListArray.add(User1);
//        EmailListArray.add(User2);
//        EmailListArray.add(User3);
//        EmailListArray.add(User4);
//        EmailListArray.add(User5);
//
//        UserResponse Response = new UserResponse();
//        if(userRequest.getPassword().equals(EmailListArray.get(0).getPassword()) &&
//        userRequest.getEmail().equals(EmailListArray.get(0).getEmail())){
//            Response.setMessage("Your Login is correct!");
//            return ResponseEntity.ok(Response);
//        } else if (userRequest.getPassword().equals(EmailListArray.get(1).getPassword()) &&
//                userRequest.getEmail().equals(EmailListArray.get(1).getEmail())) {
//            Response.setMessage("Your Login is correct!");
//            return ResponseEntity.ok(Response);
//        } else if (userRequest.getPassword().equals(EmailListArray.get(2).getPassword()) &&
//                userRequest.getEmail().equals(EmailListArray.get(2).getEmail())) {
//            Response.setMessage("Your Login is correct!");
//            return ResponseEntity.ok(Response);
//        } else if (userRequest.getPassword().equals(EmailListArray.get(3).getPassword()) &&
//                userRequest.getEmail().equals(EmailListArray.get(3).getEmail())) {
//            Response.setMessage("Your Login is correct!");
//            return ResponseEntity.ok(Response);
//        } else if (userRequest.getPassword().equals(EmailListArray.get(4).getPassword()) &&
//                userRequest.getEmail().equals(EmailListArray.get(4).getEmail())) {
//            Response.setMessage("Your Login is correct!");
//            return ResponseEntity.ok(Response);
//        } else {
//            Response.setMessage("Your Login is Incorrect. Double Check your Caps Lock and Special Characters in your Password");
//            return  ResponseEntity.badRequest().body(Response);
//        }
//    }
//
//    @GetMapping("getUsers")
//    public ArrayList<UserList> getUsers() {
//        UserResponse Response = new UserResponse();
//        ArrayList<UserList> UserModelListArray = new ArrayList<UserList>();
//        UserList User1 = new UserList("jack.rackham96@gmail.com", "jack.rackham.96", "England");
//        UserList User2 = new UserList("arno.dorian94@gmail.com", "arno.dorian.96", "France");
//        UserList User3 = new UserList("haytham.kenway92@gmail.com", "haytham.kenway.92", "United States");
//        UserList User4 = new UserList("shay.cormac93@gmail.com", "shay.cormac.93", "Carribean");
//
//        UserModelListArray.add(User1);
//        UserModelListArray.add(User2);
//        UserModelListArray.add(User3);
//        UserModelListArray.add(User4);
//
//
//        if(UserModelListArray.size() != 0) {
//            return UserModelListArray;
//        } else {
//            return null;
//        }
//    }

//    @GetMapping("usermap")
//    public static HashMap <Integer, User> getUserMap() {
//        // getUsersList()
//        // Create an ArrayList with User (email, username, address)
//        // Returns the User List as Response
//
//        ArrayList<User> userArrayList = getUserList();
//        HashMap <Integer, User> usermap = new HashMap<>();
//
//        for (int i = 0; i < userArrayList.size(); i++) {
//            usermap.put(i+1, userArrayList.get(i));
//        }
//
//        if (usermap.size() > 0) {
//            return usermap;
//        } else {
//            return null;
//        }
//    }
//    @GetMapping("user/{user_id}")
//    //GET Request --> localhost:8080/user/55 --> Returns: User ID is 55
//       public ResponseEntity<?> getUser (@PathVariable Integer user_id){
//       GeneralResponse Response = new GeneralResponse();
//       Response.setMessage("User ID is " +user_id);
//       return ResponseEntity.ok(Response);
//    }

//    @PostMapping("user/update/{user_id}")
//    // Dynamic Configuration
//    // Send raw data --> "email" : "jan@mail.com"
//    // POST Request --> localhost:8080/user/update/45 --> Returns: User ID is 45 update email is email
//    public ResponseEntity<?> updateUser (@PathVariable Integer user_id,
//                                         @RequestBody UserRequest userRequest){
//        GeneralResponse Response = new GeneralResponse();
}