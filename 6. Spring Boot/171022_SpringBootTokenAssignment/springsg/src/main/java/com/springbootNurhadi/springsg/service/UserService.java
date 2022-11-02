package com.springbootNurhadi.springsg.service;

import com.springbootNurhadi.springsg.configuration.CustomException;
import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateRequest;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.temporal.ChronoUnit;
import java.util.*;
import io.jsonwebtoken.Jws;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    Environment environment;

    public UserModel validateUserLogin(String email,String password)throws  Exception{
        UserModel user =  userRepo.getUserByEmailAndPassword(email,password).orElseThrow(()->new Exception("Please provide the username and password"));
        String token = getTokenForEmail(user);
        updateToken(token,user.getId());//update token with value for successful login in the databse
        user.setToken(token);//update the the token in   the model.
        return  user;
    }

    public boolean logout(int user_id) throws  Exception{
        updateToken("",user_id);//update token is empty for logout
        return  true;
    }

    private  void updateToken(String token ,int userId){
        userRepo.updateTokenForUserId(token,userId);//update the value in the databse against the user.
    }

    private String  getTokenForEmail(UserModel user) {
        Calendar c = Calendar.getInstance(); // starts with today's date and time
        // c.add(Calendar.DAY_OF_YEAR, 2);  // advances day by 2
        //c.add(Calendar.HOUR_OF_DAY, 10);
        c.add(Calendar.DAY_OF_YEAR,10);
        // c.add(Calendar.SECOND, 5);//set the time
        String jwtToken = Jwts.builder()
                .claim("email", user.getEmail())
                .setSubject(user.getName())
                .setId(""+user.getId())
                .setIssuedAt(new Date())
                .setExpiration(c.getTime())
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("JWT_SECRET"))
                .compact();
        return jwtToken;
    }

    public boolean validateToken(String token,Integer userId) throws  Exception{
        UserModel user = listUser(userId);//get the user details by the userid
        if(user.getToken().equals(token)){
            return  true;
        }else{
            throw new CustomException("token mismatch");
        }
    }

    public List<UserModel> listUser() throws  Exception {
        List<UserModel> userList = userRepo.findAll();
        for (UserModel userModel : userList) {
            System.out.println(userModel.getId() + " " + userModel.getEmail());
        }

        userRepo.findAll().forEach((obj) -> {
            System.out.println(obj.getId() + " " + obj.getEmail());
        });
        return userRepo.findAll();//get all the data from the userModel table.
    }

    public  UserModel listUser(Integer userId) throws  Exception {
        Optional<UserModel> userModel = userRepo.findById(userId);//get the data bases on primary key
        //user is exist
        if(userModel.isPresent()){
            return userModel.get();//get the usermodel the optional's userModel.
        }else{
            throw  new CustomException("user is not found(list user)");
        }

    }

}


