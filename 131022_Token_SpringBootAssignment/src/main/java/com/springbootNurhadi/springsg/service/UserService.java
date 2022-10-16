package com.springbootNurhadi.springsg.service;


import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateRequest;
import com.springbootNurhadi.springsg.Request.UserRequest;
import com.springbootNurhadi.springsg.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User validateLogin (String email, String password) {
        List<User> user = UserRepo.getUserByEmailAndPassword(email, password);
        return user.get(0);
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

    public boolean register (UserRequest request) {
        if (request.getEmail().equals("")) {
            return false;
        } else if (userRepo.getUserByEmail(request.getEmail()).isPresent()) {
            return false;
        }

        if (request.getPassword().equals("")) {
            return false;
        }

        if (request.getMobile().equals("")) {
            return false;
        } else {
            try {
                Integer.parseInt(request.getMobile());
            } catch (Exception e) {
                return false;
            }
        }

        if (request.getAddress().equals("")) {
            return false;
        }

        UserModel userModel = new UserModel(request.getEmail(), request.getPassword(), request.getMobile(), request.getAddress);
        userRepo.save(userModel);
        return true;
    }

    public boolean verifyEmailAndPassword (UserRequest request) {
        Optional<UserModel> test = userRepo.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
        return test.isPresent();
    }

    public boolean validateUpdate (UpdateRequest userRequest) {
        if (!userRequest.getTarget().equals("")) {
            UserModel UserOld = getUserByEmail(userRequest.getEmail());

            if (UserOld != null) {
                UserModel UserNew = UserOld;

                if (!userRequest.getEmail().equals("")){
                    UserNew = new UserModel(userRequest.getEmail(), UserNew.getPassword(), UserNew.getMobile(), UserNew.getAddress());
                }

                if (!userRequest.getPassword().equals("")) {
                    UserNew = new UserModel(userRequest.getPassword());
                }

                if (!userRequest.getMobile().equals("")) {
                    try {
                        Integer.parseInt(userRequest.getPassword());
                    } catch (Exception e) {
                        return false;
                    }
                    UserNew.setMobile(userRequest.getMobile());
                }

                if (!userRequest.getAddress().equals("")) {
                    UserNew.setAddress(userRequest.getAddress());
                }
                userRepo.save(UserNew);
                userRepo.delete(UserOld);
                return true;
            }
        }
        return false;
    }

    public boolean validateToken(UserRequest userRequest) throws Exception {
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

    public boolean validateLogin (UserRequest request) {
        request.setToken(generateToken(request.getEmail()));
        return (verifyEmailAndPassword(request) && updateToken(request));
    }

    public boolean validateLogout (UserRequest request) {
        request.setToken (null);
        return updateToken(request);
    }

    public boolean validateDelete (UserRequest userRequest) {
        if (!userRequest.getEmail().equals("")) {
            UserModel userModel = getUserByEmail(userRequest.getEmail());

            if (userModel != null) {
                userRepo.delete(userModel);
                return true;
            }
        }
        return false;
    }
}


