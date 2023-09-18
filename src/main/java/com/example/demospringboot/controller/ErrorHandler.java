package com.example.demospringboot.controller;

import com.example.demospringboot.dto.ErrorOutput;
import com.example.demospringboot.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    // Customize exception
    @ExceptionHandler
    public ResponseEntity<?> handleRuntimeException(CustomizeException exception) {
        ErrorOutput output = new ErrorOutput();
        output.setErrorCode(exception.getErrorCode());
        output.setErrorMessage(exception.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleRuntimeException(Exception exception) {
        ErrorOutput output = new ErrorOutput();
        output.setErrorCode("SERVER_ERROR");
        output.setErrorMessage("SERVER_ERROR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(output);
    }
}
