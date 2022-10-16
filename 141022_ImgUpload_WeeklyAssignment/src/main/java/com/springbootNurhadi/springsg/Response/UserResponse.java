package com.springbootNurhadi.springsg.Response;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    String email;
    String name;
    Integer id;
    String password;
    String message;
}
