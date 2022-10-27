package com.springbootNurhadi.springsg.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateReq {
    String target;
    String email;
    String password;
    String mobile;
    String address;

    public UpdateReq(String target){
        this.target = target;
    }
}
