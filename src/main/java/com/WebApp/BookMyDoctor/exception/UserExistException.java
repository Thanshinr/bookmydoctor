package com.WebApp.BookMyDoctor.exception;

public class UserExistException extends RuntimeException{
public UserExistException(String message)
{
    super(message);
}
}
