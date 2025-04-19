package com.shobhit.Backend.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value= DataIntegrityViolationException.class)
    public ResponseEntity<?> handleIntegrityViolation(){
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message("Username is already taken")
                        .status(HttpStatus.CONFLICT.value())
                        .build(),HttpStatus.CONFLICT
        );

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){

        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message(ex.getFieldError().getDefaultMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build()
                ,HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredential(BadCredentialsException ex){
        ErrorMessage error= ErrorMessage.builder()
                .message("Invalid credental").status(HttpStatus.UNAUTHORIZED.value()).build();
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
}
