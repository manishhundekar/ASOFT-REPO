package com.age2;

public class InvalidDOBException extends Exception{

	//public InvalidDOBException()
	//{
	//	super("INVALID DOB EXCEPTION");
	//}
	
	@Override
	public String getMessage()
	{
		return "INVALID DOB EXCEPTION : Date of Birth cannot be after current date";
	}
}
