package com.springbootNurhadi.springsg.model;

public class EmailList {
    String email;
    String password;

    public EmailList (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Object getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
