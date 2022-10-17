package com.springbootNurhadi.springsg.configuration;

import com.springbootNurhadi.springsg.Response.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler (CustomException.class)
    public ResponseEntity<?> handleException (CustomException e) {

        // Send error to Client's Mail
        // Store Error in DataBase
        GeneralResponse Response = new GeneralResponse();
        Response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(Response);
    }
}
