package com.company.EchoRangeService.controller;

import com.company.EchoRangeService.exception.DanHatesFivesException;
import com.company.EchoRangeService.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
                return responseEntity;
    }

    @ExceptionHandler(value = {DanHatesFivesException.class})
    public ResponseEntity<CustomErrorResponse> handleDanHatesFivesException(DanHatesFivesException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        return responseEntity;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CustomErrorResponse> anyException(Exception e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
