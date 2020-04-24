package com.neu.edu.exception;

public class BookingRequestExeption extends Exception{
	
	public BookingRequestExeption(String message)
	{
		super("BookingRequestExeption-"+message);
	}
	
	public BookingRequestExeption(String message, Throwable cause)
	{
		super("BookingRequestExeption-"+message,cause);
	}

}
