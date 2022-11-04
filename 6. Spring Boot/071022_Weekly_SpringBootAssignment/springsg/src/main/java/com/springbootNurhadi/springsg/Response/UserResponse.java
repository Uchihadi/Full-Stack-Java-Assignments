package com.springbootNurhadi.springsg.Response;

public class UserResponse {
    public UserResponse() {

    }

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
}
