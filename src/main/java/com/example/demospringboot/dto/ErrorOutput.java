package com.example.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorOutput {
    private String errorCode;
    private String errorMessage;
}
