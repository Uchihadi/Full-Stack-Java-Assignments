package com.springbootNurhadi.springsg.service;


import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateReq;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserResponse register (UserRequest request) {
        UserResponse Response = new UserResponse();

        if (request.getEmail().equals("")) {
            Response.setMessage("Email Cannot be Empty");
            return Response;
        } else if (userRepo.getUserByEmail(request.getEmail()).isPresent()) {
            Response.setMessage("Email has already been registered!");
            return Response;
        }

        if (request.getPassword().equals("")) {
            Response.setMessage("Password Cannot be Empty");
            return Response;
        }

        if (request.getMobile().equals("")) {
            Response.setMessage("Mobile Number Cannot be Empty");
            return Response;
        } else {
            try {
                Integer.parseInt(request.getMobile());
            } catch (Exception e) {
                Response.setMessage("The Mobile Number is Invalid");
                return Response;
            }
        }

        if (request.getAddress().equals("")) {
            Response.setMessage("Address Cannot be Empty");
            return Response;
        }

        UserModel userModel = new UserModel(request.getMobile(), request.getEmail(),
                request.getPassword(), request.getAddress());
        userRepo.save(userModel);

        Response.setUserModel(userModel);
        Response.setMessage("User has been registered successfully!");
        return Response;
    }

    public UserResponse verifyEmailAndPassword (UserRequest userRequest) {
        UserResponse Response = new UserResponse();
        Optional<UserModel> Testing = userRepo.getUserByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());

        if (Testing.isPresent()) {
            Response.setUserModel(Testing.get());
            Response.setMessage("User Logged In Successfully");
        } else {
            Response.setMessage("Unable to Log In, please check your credentials");
        }
        return Response;
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





    public boolean updateUser (UpdateReq request) {
        if (!request.getTarget().equals("")) {
            UserModel UserOld = getUserByEmail(request.getEmail());

            if (UserOld != null) {
                UserModel UserNew = UserOld;

                if (!request.getEmail().equals("")){
                    UserNew = new UserModel(request.getEmail());
                }

                if (!request.getPassword().equals("")) {
                    UserNew = new UserModel(request.getPassword());
                }

                if (!request.getMobile().equals("")) {
                    try {
                        Integer.parseInt(request.getPassword());
                    } catch (Exception e) {
                        return false;
                    }
                    UserNew.setMobile(request.getMobile());
                }

                if (!request.getAddress().equals("")) {
                    UserNew.setAddress(request.getAddress());
                }

                userRepo.save(UserNew);
                userRepo.delete(UserOld);
                return true;
            }
        }

        return false;
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

    public boolean validateUpdate(UpdateReq updateReq) {
        boolean b = false;
        if (b) return true;
        else return false;
    }
}


