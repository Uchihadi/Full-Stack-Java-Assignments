package com.springbootNurhadi.springsg.service;


import com.springbootNurhadi.springsg.Repo.UserRepo;
import com.springbootNurhadi.springsg.Response.UserResponse;
import com.springbootNurhadi.springsg.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    public HashMap<Integer, UserModel> UserGet() {
        HashMap<Integer, UserModel> userModelHashMap = new HashMap<>();

        UserModel u1 = new UserModel(1, "John F Kennedy", "jfk13@gmail.com", "jfk@54");
        UserModel u2 = new UserModel(2, "Fidel Castro", "fcastrocuba@gmail.com", "fcastro60");
        UserModel u3 = new UserModel(3, "Nikita Khruschchev", "Khrushamerica@gmail.com", "NKVD");
        UserModel u4 = new UserModel(4, "Robert McNamara", "mcnamara@gmail.com", "rob44");
        UserModel u5 = new UserModel(5, "Allen Dulles", "allendulles@gmail.com", "adules22");

        userModelHashMap.put(1, u1);
        userModelHashMap.put(2, u2);
        userModelHashMap.put(3, u3);
        userModelHashMap.put(4, u4);
        userModelHashMap.put(5, u5);

        return userModelHashMap;
    }

    public ResponseEntity<?> getOneUser(Integer id) {
        HashMap<Integer, UserModel> userModelHashMap = UserGet();
        UserResponse Response = new UserResponse();

        // To find out if userHashMap size has some values
        if (id > userModelHashMap.size()) {
            Response.setMessage("User's Credentials are not found");
            return ResponseEntity.badRequest().body(Response);
        } else {
            UserModel user = userModelHashMap.get(id);
            Response.setId(user.getId());
            Response.setMessage("User: " + user.getId());
            Response.setName(user.getName());
            Response.setEmail(user.getEmail());
            return ResponseEntity.ok(Response);
        }
    }
}
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
    
//    public UserModel validateLogin (String email, String password) throws Exception {
//        UserModel user = UserRepo.getUserByEmailAndPassword(email, password).orElseThrow(()
//        -> new Exception("Invalid UserName and Password, Please Try Again."));
//        return user;
//    } public void viewUser() throws Exception {
//        return;
//    }

