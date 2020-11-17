package com.poc.bem.demo.exceptions;

public class AppUserNotFoundException extends RuntimeException {
    public AppUserNotFoundException(){
        super();
    }

    public AppUserNotFoundException(String message){
        super(message);
    }

    public AppUserNotFoundException(Throwable cause){
        super(cause);
    }

    public AppUserNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
