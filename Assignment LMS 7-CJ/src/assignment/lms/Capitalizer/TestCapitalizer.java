package assignment.lms.Capitalizer;

import java.util.Scanner;

public class TestCapitalizer {

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String input = sc.nextLine();
		System.out.println(Capitalizer.capitalize(input));
		sc.close();
	}

}
