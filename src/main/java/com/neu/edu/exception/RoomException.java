package com.neu.edu.exception;

public class RoomException extends Exception{
	
	public RoomException(String message)
	{
		super("RoomException-"+message);
	}
	
	public RoomException(String message, Throwable cause)
	{
		super("RoomException-"+message,cause);
	}

}
