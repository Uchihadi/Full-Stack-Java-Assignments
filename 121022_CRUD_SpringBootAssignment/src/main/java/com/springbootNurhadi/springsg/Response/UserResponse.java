package com.springbootNurhadi.springsg.Response;
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
}
