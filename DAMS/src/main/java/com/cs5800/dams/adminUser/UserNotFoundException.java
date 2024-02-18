package com.cs5800.dams.adminUser;

public class UserNotFoundException extends Throwable{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
