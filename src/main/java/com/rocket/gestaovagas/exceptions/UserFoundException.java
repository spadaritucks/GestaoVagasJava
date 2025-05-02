package com.rocket.gestaovagas.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException (){
        super("Usuario já existe");
    }
}
