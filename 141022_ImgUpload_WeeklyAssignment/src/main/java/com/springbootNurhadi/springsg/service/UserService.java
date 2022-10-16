package com.springbootNurhadi.springsg.service;


import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateReq;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.configuration.CustomException;
import com.springbootNurhadi.springsg.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    private System environment;

    public UserModel validateLogin (String email, String password) throws Exception {
        UserModel userModel = userRepo.getUserByEmailAndPassword(email, password).orElseThrow(()
                -> new Exception("Wrong Username/Password. Please Try Again!"));
        String token = tokenCreation(userModel);
        updateTokenAuth(token, userModel.getId());
        userModel.setToken(token);
        return userModel;
    }

    private String tokenCreation (UserModel userModel) {
        Calendar a = Calendar.getInstance();
        a.add(Calendar.DAY_OF_YEAR, 4);
        String token = Jwts.builder().claim("email", userModel.getEmail())
                .setSubject(userModel.getName()).setId("" + userModel.getId())
                .setIssuedAt(new Date()).setExpiration(a.getTime())
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("JWT_SECRET"))
                .compact();
        return token;
    }

    public boolean checkToken (String token) throws CustomException {
        Jwts.parser().setSigningKey(environment.getProperty("JWT_SECRET")).parseClaimsJws(token);
        return true;
    }

    private void updateTokenAuth (String token, Integer id) {
        userRepo.updateTokenUsingUserId(token, id);
    }

    public boolean validateTokenAuth(String token, Integer id) throws Exception {
        UserModel userModel = new UserModel();
        if (userModel.getToken().equals(token)){
            return true;
        } else {
            throw new CustomException("Token is wrong");
        }
    }

    public List<UserModel> userModel(Integer id) throws Exception {
        return userRepo.findAll();
    }

    private String generateToken (String email) {
        String emailEncoded = Arrays.toString(Base64.getEncoder().encode(email.getBytes()));
        return emailEncoded + System.currentTimeMillis();
    }

//    private boolean updateToken (UserRequest request) {
//        UserModel userModel = getUserByEmail(request.getEmail());
//        if (userModel != null) {
//            userModel.setToken (request.getToken());
//            userRepo.save(userModel);
//            return true;
//        }
//        return false;
//    }

    private String getTokenForEmail (UserModel userModel) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 10);
        String jwtToken;
    }

    public boolean validateToken(String token, Integer integer_userId) {
    }
    
    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepo.findAll();
    }

    public ArrayList<String> getAllEmails() {
        ArrayList<UserModel> users = (ArrayList<UserModel>) userRepo.findAll();
        ArrayList<String> emails = new ArrayList<>();

        for (UserModel user:users) {
            emails.add(user.getEmail());
        }

        return emails;
    }

//    public UserModel getUserByEmail(String email) {
//        if(!email.equals("")) {
//            Optional<UserModel> test = userRepo.getUserByEmail(email);
//
//            if (test.isPresent()) {
//                return test.get();
//            }
//        }
//
//        return null;
//    }

//    public boolean register (UserRequest request) {
//        if (request.getEmail().equals("")) {
//            return false;
//        } else if (userRepo.getUserByEmail(request.getEmail()).isPresent()) {
//            return false;
//        }
//
//        if (request.getPassword().equals("")) {
//            return false;
//        }
//
//        if (request.getMobile().equals("")) {
//            return false;
//        } else {
//            try {
//                Integer.parseInt(request.getMobile());
//            } catch (Exception e) {
//                return false;
//            }
//        }
//
//        if (request.getAddress().equals("")) {
//            return false;
//        }
//
//        UserModel userModel = new UserModel(request.getEmail(), request.getPassword(), request.getMobile(), request.getAddress);
//        userRepo.save(userModel);
//        return true;
//    }

    public boolean verifyEmailAndPassword (UserRequest request) {
        Optional<UserModel> test = userRepo.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
        return test.isPresent();
    }

//    public boolean updateUser (UpdateReq request) {
//        if (!request.getTarget().equals("")) {
//            UserModel UserOld = getUserByEmail(request.getEmail());
//
//            if (UserOld != null) {
//                UserModel UserNew = UserOld;
//
//                if (!request.getEmail().equals("")){
//                    UserNew = new UserModel(request.getEmail(), UserNew.getPassword(), UserNew.getMobile(), UserNew.getAddress());
//                }
//
//                if (!request.getPassword().equals("")) {
//                    UserNew = new UserModel(request.getPassword());
//                }
//
//                if (!request.getMobile().equals("")) {
//                    try {
//                        Integer.parseInt(request.getPassword());
//                    } catch (Exception e) {
//                        return false;
//                    }
//                    UserNew.setMobile(request.getMobile());
//                }
//
//                if (!request.getAddress().equals("")) {
//                    UserNew.setAddress(request.getAddress());
//                }
//
//                userRepo.save(UserNew);
//                userRepo.delete(UserOld);
//                return true;
//            }
//        }
//
//        return false;
//    }

    public boolean userLogin (UserRequest request) {
        request.setToken(generateToken(request.getEmail()));
        return (verifyEmailAndPassword(request) && updateToken(request));
    }

    private boolean updateToken(UserRequest request) {
    }

    public boolean userLogout (UserRequest request) {
        request.setToken (null);
        return updateToken(request);
    }

    public void checkJWTToken(String token) {

    }
}


