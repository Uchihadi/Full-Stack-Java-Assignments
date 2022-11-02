package com.springbootNurhadi.springsg.model;

import net.minidev.json.annotate.JsonIgnore;
import lombok.*;
import javax.persistence.*;

// Default Operations for Database ---> CRUD; Not achievable without the POJO class
// Create another Repository Layer; Each Model will require one Repository --> If you need for CRUD
// Optional. When you want to execute any Queries you will need another Repo Layer

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table (name = "users")
public class UserModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Automatically generated strategy types
    String name;
    String email;
    String mobile;

    @JsonIgnore
    String password;
    String address;
    String token = null;

    public UserModel (String email, String password, String address, String mobile){
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobile = mobile;

    }

}
