package com.Project.Disney.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String error) {
        super(error);
    }
}
