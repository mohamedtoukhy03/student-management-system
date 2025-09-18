package com.School.StudentManagementSystem.advice;

import com.School.StudentManagementSystem.exception.EntityErrorResponse;
import com.School.StudentManagementSystem.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException ex) {
        EntityErrorResponse error = new EntityErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return new  ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(RuntimeException e) {
        EntityErrorResponse error = new EntityErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return new  ResponseEntity<>(error.toString(), HttpStatus.BAD_REQUEST);
    }

}
