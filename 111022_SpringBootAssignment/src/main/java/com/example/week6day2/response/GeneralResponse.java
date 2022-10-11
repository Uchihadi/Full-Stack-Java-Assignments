package com.example.week6day2.response;

public class GeneralResponse {
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message, int i) {
        Message = message;
    }

    public GeneralResponse(){

    }

    public GeneralResponse(String Message){

    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    String Message;
    String myName;

    public void setMessage(String you_are_correct) {
    }
}
