package com.ilacad.employeeapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    // Exception handler for not existed employee
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException (EmployeeNotFoundException exc) {

        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Global Exception handler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException (Exception exc) {

        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
