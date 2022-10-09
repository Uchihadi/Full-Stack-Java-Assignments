package com.springbootNurhadi.springsg.model;

public class UserList {
    String email;
    String password;
    String address;

    public UserList (String email, String password, String address){
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public UserList (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Object getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}
