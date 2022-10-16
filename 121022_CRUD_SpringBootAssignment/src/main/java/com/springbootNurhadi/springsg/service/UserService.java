package com.springbootNurhadi.springsg.service;


import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Request.UpdateReq;
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

        UserModel userModel = new UserModel(request.getEmail());
        userRepo.save(userModel);
        return true;
    }

    public List<User> verifyEmailAndPassword (UserRequest request) {
        List<User> test = UserRepo.getUserByEmailAndPassword(request.getEmail(), request.getPassword());
        return test;
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

//    public boolean userLogin (UserRequest request) {
//        request.setToken(generateToken(request.getEmail()));
//        return (verifyEmailAndPassword(request) && updateToken(request));
//    }

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

//    public HashMap<Integer, UserModel> UserGet() {
//        HashMap<Integer, UserModel> userModelHashMap = new HashMap<>();
//
//        UserModel u1 = new UserModel(1, "John F Kennedy", "jfk13@gmail.com", "jfk@54");
//        UserModel u2 = new UserModel(2, "Fidel Castro", "fcastrocuba@gmail.com", "fcastro60");
//        UserModel u3 = new UserModel(3, "Nikita Khruschchev", "Khrushamerica@gmail.com", "NKVD");
//        UserModel u4 = new UserModel(4, "Robert McNamara", "mcnamara@gmail.com", "rob44");
//        UserModel u5 = new UserModel(5, "Allen Dulles", "allendulles@gmail.com", "adules22");
//
//        userModelHashMap.put(1, u1);
//        userModelHashMap.put(2, u2);
//        userModelHashMap.put(3, u3);
//        userModelHashMap.put(4, u4);
//        userModelHashMap.put(5, u5);
//
//        return userModelHashMap;
//    }
//
//    public ResponseEntity<?> getOneUser(Integer id) {
//        HashMap<Integer, UserModel> userModelHashMap = UserGet();
//        UserResponse Response = new UserResponse();
//
//        // To find out if userHashMap size has some values
//        if (id > userModelHashMap.size()) {
//            Response.setMessage("User's Credentials are not found");
//            return ResponseEntity.badRequest().body(Response);
//        } else {
//            UserModel user = userModelHashMap.get(id);
//            Response.setId(user.getId());
//            Response.setMessage("User: " + user.getId());
//            Response.setName(user.getName());
//            Response.setEmail(user.getEmail());
//            return ResponseEntity.ok(Response);
//        }
//    }


//    public boolean createUser (UserLoginRequest userLoginRequest) throws Exception {
//        try {
//            Optional<UserModel> userEmailExists = userRepo.getValidEmail(userLoginRequest.getEmail());
//            if(userEmailExists.isPresent()) {
//                throw new Exception("Email Exists");
//            }
//            UserModel userModel = new UserModel();
//            userModel.setEmail(userLoginRequest.getEmail());
//            userModel.setName(userLoginRequest.getName());
//            userModel.setPassword(userLoginRequest.getPassword());
//            userModel.setMobile(userLoginRequest.getMobile());
//            userModel.setAddress(userLoginRequest.getAddress());
//            userRepo.save(userModel);
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }


//    public void viewUser() throws Exception {
//        return;
//    }

//    @Autowired
//    UserRepo userRepo;
//    public boolean createUser (LoginUserRequest loginUserRequest) throws Exception {
//        try {
//            Optional<UserModel> userEmailExist = userRepo.getValidEmail(loginUserRequest.getEmail());
//            if(userEmailExist.isPresent()) {
//                throw new Exception("Email has already existed!");
//            }
//
//        }
//    }
}


