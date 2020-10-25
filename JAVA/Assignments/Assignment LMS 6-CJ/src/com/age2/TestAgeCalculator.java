package com.age2;

import java.text.ParseException;
import java.util.Scanner;

public class TestAgeCalculator {

	public static void main(String[] args) {
		
		AgeCalculator2 ac= new AgeCalculator2(); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Date of Birth :");
		String DOB = sc.nextLine();
		try {
			System.out.println(ac.calculateAge(DOB));;
		} catch (ParseException  e) {
			System.out.println("Date should be in DD/MM/YYYY format only");
			e.printStackTrace();
		}catch (InvalidDOBException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		System.out.println("DONE");
	}

}
