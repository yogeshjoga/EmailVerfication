package org.api.emailverfication.controller.controllerAdvisor;

import org.api.emailverfication.exceptions.WrongOTPException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(WrongOTPException.class)
    public ResponseEntity<Exception> wrongOTP(Exception ex){
        return ResponseEntity.status(400).body(ex);
    }

}
