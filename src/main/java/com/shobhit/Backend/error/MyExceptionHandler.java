package com.shobhit.Backend.error;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;


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
                .message("Invalid credential").status(HttpStatus.UNAUTHORIZED.value()).build();
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFound(UsernameNotFoundException ex){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message(ex.getMessage()).status(HttpStatus.UNAUTHORIZED.value()).build();
        return new ResponseEntity<>(errorMessage,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value= EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException ex){
        ErrorMessage errorMessage=ErrorMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).build();
        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseEntity<?> handleExpiredJwt(){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message("Jwt token has expired")
                .status(HttpStatus.UNAUTHORIZED.value())
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDenied(){
        ErrorMessage errorMessage=ErrorMessage.builder()
                .message("Access is denied")
                .status(HttpStatus.FORBIDDEN.value())
                .build();
        return  new ResponseEntity<>(errorMessage,HttpStatus.FORBIDDEN);
    }
}
