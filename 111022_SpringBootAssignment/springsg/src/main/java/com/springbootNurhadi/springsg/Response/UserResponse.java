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
    String Message;

    public UserResponse(String Message){ //POJO Class Message
        this.Message = Message;
    }
}
