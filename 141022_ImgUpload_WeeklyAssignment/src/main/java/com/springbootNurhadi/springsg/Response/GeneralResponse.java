package com.springbootNurhadi.springsg.Response;

import com.springbootNurhadi.springsg.model.UserModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GeneralResponse {
    // Creates a general response for the entire application
    String Message;
    UserModel userModel = null;

}
