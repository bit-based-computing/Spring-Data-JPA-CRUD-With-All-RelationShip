package com.jpa.curd.curd.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationRunTimeException extends RuntimeException{

    public ApplicationRunTimeException(){
        super();
    }

    public ApplicationRunTimeException(String message){
        super(message);
    }

    public  ApplicationRunTimeException(String message, Throwable cause){
        super(message, cause);
    }

}
