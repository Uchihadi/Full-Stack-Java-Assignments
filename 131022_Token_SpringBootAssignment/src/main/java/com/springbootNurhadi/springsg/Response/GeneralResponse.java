package com.springbootNurhadi.springsg.Response;

import lombok.*;
import com.springbootNurhadi.springsg.model.UserModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GeneralResponse {
    // Creates a general response for the entire application
    // Add String --> Right Click Getter and Setter
    String Message = "";
    UserModel userModel = null;
    public GeneralResponse(String Message){
        this.Message = Message;
    }

    public GeneralResponse(UserModel userModel) {
        this.userModel = userModel;
    }
}
