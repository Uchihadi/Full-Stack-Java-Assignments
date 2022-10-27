package com.springbootNurhadi.springsg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

// Default Operations for Database ---> CRUD; Not achievable without the POJO class
// Create another Repository Layer; Each Model will require one Repository --> If you need for CRUD
// Optional. When you want to execute any Queries you will need another Repo Layer

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class UserModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Automatically generated strategy types
    Integer id;
    String name;
    String email;
    String mobile;
    String address;
    String token;
    @JsonIgnore
    String password;

    public UserModel(Integer id, String name, String email, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public UserModel(String email) {

    }
}
