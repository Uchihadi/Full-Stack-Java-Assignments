package com.springbootNurhadi.springsg.service;

import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateReq;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Service
public class ExtraServices {
    @Autowired
    UserRepo userRepo;

    public boolean validateUpdate(UpdateReq updateReq) {
        boolean b = false;
        if (b) return true;
        else return false;
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

    public UserModel getUserByEmail(String email) {
        if(!email.equals("")) {
            Optional<UserModel> test = userRepo.getUserByEmail(email);

            if (test.isPresent()) {
                return test.get();
            }
        }
        return null;
    }

    public boolean validateToken (UserRequest userRequest) throws Exception {
        UserModel userModel = getUserByEmail(userRequest.getEmail());
        if (userModel != null) {
            return userModel.getToken().equals(userRequest.getToken());
        }
        return false;
    }

    private String generateToken (String email) {
        String emailEncoded = Arrays.toString(Base64.getEncoder().encode(email.getBytes()));
        return emailEncoded + System.currentTimeMillis();
    }

    private boolean updateToken (UserRequest request) {
        UserModel userModel = getUserByEmail(request.getEmail());
        if (userModel != null) {
            userModel.setToken (request.getToken());
            userRepo.save(userModel);
            return true;
        }
        return false;
    }

    public boolean userLogout (UserRequest request) {
        request.setToken (null);
        return updateToken(request);
    }

    public boolean validateLogout(UserRequest userRequest) {
        return false;
    }

    public boolean validateDelete(UserRequest userRequest) {
        return true;
    }

    public boolean validateLogin(UserRequest userRequest) {
        return true;
    }

}
