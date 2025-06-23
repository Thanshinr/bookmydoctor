package com.WebApp.BookMyDoctor.exception;

public class LeaveRequestException extends RuntimeException{
    public LeaveRequestException(String message)
    {
        super(message);
    }
}
