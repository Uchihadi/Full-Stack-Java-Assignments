package com.springbootNurhadi.springsg.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class UpdateRequest {
    String target = null;
    String email = null;
    String password = null;
    String mobile = null;
    String address = null;

    public UpdateRequest (String target){
        this.target = target;
    }
}
