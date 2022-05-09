package com.webService.webServices.controllers;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.webService.webServices.models.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

// Code taken from 2U Full Stack Java class curriculum
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<CustomErrorResponse>> handleInputValidationErrors(MethodArgumentNotValidException exc) {
        // BindingResult holds the validation errors
        BindingResult result = exc.getBindingResult();

        // Validation errors are stored in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        List<CustomErrorResponse> errorResponseList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, fieldError.getDefaultMessage());
            errorResponseList.add(errorResponse);
        }

        // Create and return the ResponseEntity
        ResponseEntity<List<CustomErrorResponse>> responseEntity = new ResponseEntity<>(errorResponseList, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CustomErrorResponse> anyException(Exception e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
