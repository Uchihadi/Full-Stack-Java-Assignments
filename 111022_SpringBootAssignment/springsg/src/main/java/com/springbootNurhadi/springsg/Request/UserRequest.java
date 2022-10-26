package com.springbootNurhadi.springsg.Request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    String email;
    String password;
    String message;
    Integer num1;
    Integer num2;
}
