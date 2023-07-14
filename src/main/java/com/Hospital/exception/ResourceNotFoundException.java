package com.Hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(long id){
        super("Resource not found for id: "+id);
    }

//    private String resourceName;
//
//    private String fieldName;
//
//    private String fieldValue;
//
//    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
//        this.resourceName = resourceName;
//        this.fieldName = fieldName;
//        this.fieldValue = fieldValue;
//    }





}
