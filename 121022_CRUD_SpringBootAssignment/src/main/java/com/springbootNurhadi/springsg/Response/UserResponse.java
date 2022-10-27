package com.springbootNurhadi.springsg.Response;
import com.springbootNurhadi.springsg.model.UserModel;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    String email;
    String name;
    Integer id;

    @JsonIgnore
    String password;
    String Message;

    UserModel userModel = null;

    public UserResponse(String message) {

    }
}
