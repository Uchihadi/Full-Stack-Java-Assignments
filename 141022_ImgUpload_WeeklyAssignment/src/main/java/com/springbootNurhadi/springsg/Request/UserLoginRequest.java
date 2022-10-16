package com.springbootNurhadi.springsg.Request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    Integer id;
    String email;
    String password;
    String name;
    String address;
    String mobile;

}
