package com.idat.semana2.exceptions.model;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User id not found : " + id);
    }

}
