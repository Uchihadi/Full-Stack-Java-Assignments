package com.springbootNurhadi.springsg.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class UpdateReq {
    String target = null;
    String email = null;
    String password = null;
    String mobile = null;
    String address = null;

    public UpdateReq (String target){
        this.target = target;
    }
}
