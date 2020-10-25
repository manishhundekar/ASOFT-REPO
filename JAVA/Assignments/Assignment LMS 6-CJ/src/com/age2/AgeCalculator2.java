package com.age2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class AgeCalculator2 {

	public double calculateAge(String dob) throws ParseException,InvalidDOBException
	{
		Date currentdate = new Date();
		long currentmillis = currentdate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(dob);
		System.out.println(date);
		long dobmillis = date.getTime();
		long agemillis = currentmillis - dobmillis;
		if(agemillis < 0)
		{
			throw new InvalidDOBException();
		}
		double years = agemillis/1000/60/60/24/366;
		//System.out.println(years);
		return years;
		
	}
}
