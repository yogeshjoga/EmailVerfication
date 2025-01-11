package org.api.emailverfication.controller.controllerAdvisor;

import org.api.emailverfication.exceptions.UserNotFoundException;
import org.api.emailverfication.exceptions.WrongOTPException;
import org.api.emailverfication.exceptions.WrongPasswordException;
import org.api.emailverfication.exceptions.WrongUserNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

//    @ExceptionHandler(WrongOTPException.class)
//    public ResponseEntity<Exception> wrongOTP(Exception ex){
//        return ResponseEntity.status(400).body(ex);
//    }
//
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<Exception> userNotFound(Exception ex){
//        return ResponseEntity.status(400).body(ex);
//    }
//
//    @ExceptionHandler(WrongPasswordException.class)
//    public ResponseEntity<Exception> wrongPassword(Exception ex){
//        return ResponseEntity.status(400).body(ex);
//    }
//
//    @ExceptionHandler(WrongUserNameException.class)
//    public ResponseEntity<Exception> wrongUserName(Exception ex){
//        return ResponseEntity.status(400).body(ex);
//    }


    /**
     * Enhanced version of the 400 exception
     * List of exception classes injected
     */
    @ExceptionHandler({ WrongOTPException.class,UserNotFoundException.class,
            WrongPasswordException.class ,WrongUserNameException.class})
    public ResponseEntity<Exception> invalidException(Exception ex){
        return ResponseEntity.status(400).body(ex);
    }


}
