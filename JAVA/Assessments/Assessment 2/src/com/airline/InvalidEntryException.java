package com.airline;

public class InvalidEntryException extends Exception{
	

	private static final long serialVersionUID = 1L;
	public InvalidEntryException() {}
	public InvalidEntryException(String msg)
	{
		super(msg);
	}
	//@Override
	//public String getMessage()
	//{
	//	return "Invalid Entry by the User";
	//}

}
