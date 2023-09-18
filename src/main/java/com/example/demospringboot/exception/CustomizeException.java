package com.example.demospringboot.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomizeException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public CustomizeException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
