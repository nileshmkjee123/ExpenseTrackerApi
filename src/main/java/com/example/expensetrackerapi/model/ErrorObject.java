package com.example.expensetrackerapi.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private LocalDateTime timeStamp;
}
