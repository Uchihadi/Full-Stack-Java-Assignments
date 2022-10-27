package com.springbootNurhadi.springsg.Response;
import lombok.*;
import com.springbootNurhadi.springsg.model.UserModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {

    String Message;
    UserModel userModel;

    public GeneralResponse(String Message){ //POJO Class Message

        this.Message = Message;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserModel getUser() {
        return userModel;
    }
}
