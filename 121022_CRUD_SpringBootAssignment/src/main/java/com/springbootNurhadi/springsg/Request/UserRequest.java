package com.springbootNurhadi.springsg.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    String email;
    String password;
    String name;
    String address;
    String mobile;
    String token;
}
