package com.example.week6day2.services;

import com.example.week6day2.model.UserModel;
import com.example.week6day2.repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

@Service //Service is like normal class, is just that the Annotations need mentioned as @Services
public class UserServices {
    @Autowired //Create class inside the Application Context under the IoC Containers (using Autowired concept)
    UserRepo userRepo; //Service Class Name, the Object --> To inject repository into the Services Model
    public int addition (int a, int b) {
        int add = a+b;
        return add;
    }

    public boolean validateUserLogin(String email,String password) throws Exception{
        if(email.equals("admin@gmail.com") &&  password.equals("admin")){
            return true;
        } else { //if the email and password condition is false then it will throw new exception --> It will goes
            // directly to the catch block in UserController file
            throw new Exception("Please provide the username and password");
        }
    }

    public boolean createUser(){
        UserModel userModel = new UserModel();
        userModel.setEmail("test@gmail.com");
        userModel.setMobile("94454455");
        userModel.setName("Test");
        userModel.setID(2);

        userRepo.save(userModel); // Insert Data into the Table
        return true;
    }

    public HashMap<Integer, UserModel> UserGet() {
        HashMap<Integer, UserModel> userModelHashMap = new HashMap<>();

        UserModel u1 = new UserModel(1, "JackRackham@gmail.com", "JackRackham22", "Jack Rackham");        UserModel u1 = new UserModel(1, "JackRackham@gmail.com", "JackRackham22", "Jack Rackham");
        UserModel u2 = new UserModel(2, "HaythamKenway@gmail.com", "HKenway3", "Haytham Kenway");
        UserModel u3 = new UserModel(3, "JohnnyRed@gmail.com", "JRedd2", "Johnny Redd");
        UserModel u4 = new UserModel(4, "HenryMeyer@gmail.com", "HMeyer23", "Henry Meyer");
        UserModel u5 = new UserModel(5, "JonasApalogos@gmail.com", "JApologos34", "Jonas Apalogos");

        userModelHashMap.put(1, u1);
        userModelHashMap.put(2, u2);
        userModelHashMap.put(3, u3);
        userModelHashMap.put(4, u4);
        userModelHashMap.put(5, u5);

        return userModelHashMap;
    }
}
