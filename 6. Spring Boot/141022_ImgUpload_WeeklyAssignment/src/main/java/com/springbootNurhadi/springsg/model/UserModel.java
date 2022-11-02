package com.springbootNurhadi.springsg.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import lombok.*;

// Default Operations for Database ---> CRUD; Not achievable without the POJO class
// Create another Repository Layer; Each Model will require one Repository --> If you need for CRUD
// Optional. When you want to execute any Queries you will need another Repo Layer
// Import Project Lombok for easier Method Integration

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @JsonIgnore // Does not share as Response, can be used to set values instead
    String password;
    String profile_pic;

}
