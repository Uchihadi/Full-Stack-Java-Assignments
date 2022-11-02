package com.springbootNurhadi.springsg.Request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    String email;
    String password;
    String address;
    String mobile;
    String token;

}
