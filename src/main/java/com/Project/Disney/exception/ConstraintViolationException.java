package com.Project.Disney.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String error){
        super(error);
    }
}
