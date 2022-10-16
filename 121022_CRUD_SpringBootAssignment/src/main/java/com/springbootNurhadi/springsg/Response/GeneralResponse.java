package com.springbootNurhadi.springsg.Response;

import com.springbootNurhadi.springsg.model.UserModel;

public class GeneralResponse {
    // Creates a general response for the entire application
    // Add String --> Right Click Getter and Setter
    String Message = "";
    UserModel userModel = null;

    public GeneralResponse() {

    }

    public GeneralResponse(UserModel userModel) {
        this.userModel = userModel;
    }


    //    public String getMyName() {
//
//        return myName;
//    }
//
//    public void setMyName(String myName) {
//        this.myName = myName;
//    }
//
//    String myName;
    public GeneralResponse(String Message){ //POJO Class Message

        this.Message = Message;
    }

    public String getMessage() { // Get Message --> String

        return Message;
    }

    public void setMessage(String message) { //Set Message --> Void --> Argument String
        Message = message;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserModel getUser() {
        return userModel;
    }
}
