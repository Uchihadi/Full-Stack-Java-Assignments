package com.springbootNurhadi.springsg.Response;
import lombok.*;

//import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    String email;
    String name;
    Integer id;
    String message;

    public UserResponse(String message){ //POJO Class Message
        this.message = message;
    }
}
