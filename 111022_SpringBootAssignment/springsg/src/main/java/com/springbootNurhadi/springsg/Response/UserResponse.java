package com.springbootNurhadi.springsg.Response;
import lombok.*;

import javax.persistence.Entity;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
public class UserResponse {

    private String email;
    private String name;
    private Integer id;

    public UserResponse() {

    }

//    public UserResponse(Integer id, String email, String name, String password) {
//        this.id = id;
//        this.email = email;
//        this.name = name;
//        this.password = password;
//    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public UserResponse(String message) {
        Message = message;
    }

    String Message;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
