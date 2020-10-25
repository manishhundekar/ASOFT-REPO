package com.test;

import java.util.ArrayList;

import com.airline.Airlines;
import com.airline.Domestic;
import com.airline.International;
import com.airline.InvalidEntryException;

public class TestAirline {

	public static void main(String[] args) throws InvalidEntryException {
		
		ArrayList<Airlines> airlines = new ArrayList<>();
		
		Domestic domestic1 = new Domestic("BOEING1001", "Bangalore", "Bidar", "Z001");
		Domestic domestic2 = new Domestic("BOEING1002", "Bangalore", "Gulbarga", "Z002");
		Domestic domestic3 = new Domestic("BOEING1001", "Bangalore", "Hyderabad", "Z003");
		//ERROR1 - Starts without BOEING
		//Domestic domestic4 = new Domestic("1001", "Bangalore", "Hyderabad", "Z003");
		//ERROR2 - Out of Zone
		//Domestic domestic5 = new Domestic("BOEING1001", "Bangalore", "Hyderabad", "Z004");
		//ERROR3 - Same Source and Destination
		//Domestic domestic6 = new Domestic("1001", "Bangalore", "Bangalore", "Z004");
		
		International international1 = new International("BOEING2001", "Bangalore", "New York", "I001");
		International international2 = new International("BOEING2002", "Hyderabad", "Sydney", "I002");
		International international3 = new International("BOEING2003", "Singapore", "Bangalore", "I003");
		
		airlines.add(domestic1);
		airlines.add(domestic2);
		airlines.add(domestic3);
		airlines.add(international1);
		airlines.add(international2);
		airlines.add(international3);
		
		
		for(Airlines airline : airlines)
		{
			airline.bookTicket(3); // No of Tickets = 3
		}
		
		System.out.println("DONE");
	}

}
