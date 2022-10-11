package com.example.week6day2.model;

import javax.persistence.*;
// Default Operations for Database ---> CRUD; Not achievable without the POJO class
// Create another Repository Layer; Each Model will require one Repository --> If you need for CRUD
// Optional. When you want to execute any Queries you will need another Repo Layer

@Entity
@Table (name = "user")
public class UserModel {
    public UserModel(int ID, String email, String password, String name) {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //Automatically generated strategy types
    Integer ID; //Unique Identity
    String name, email, password, mobile;
}
