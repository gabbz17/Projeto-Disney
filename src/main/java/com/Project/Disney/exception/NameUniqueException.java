package com.Project.Disney.exception;

public class NameUniqueException extends RuntimeException{
    public NameUniqueException(String error){
        super(error);
    }
}
