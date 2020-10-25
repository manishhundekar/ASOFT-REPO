package com.age;

import java.text.ParseException;
import java.util.Scanner;

public class TestAgeCalculator {

	public static void main(String[] args) {
		
		AgeCalculator1 ac= new AgeCalculator1(); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Date of Birth :");
		String DOB = sc.nextLine();
		try {
			System.out.println(ac.calculateAge(DOB));;
		} catch (ParseException e) {
			System.out.println("Date should be in DD/MM/YYYY format only");
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		System.out.println("DONE");
	}

}
