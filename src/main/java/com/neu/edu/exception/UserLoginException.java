package com.neu.edu.exception;

public class UserLoginException extends Exception{
	
	public UserLoginException(String errorMessage, Throwable reason) {
		super("User Login Exception:"+errorMessage,reason);
	}

}
