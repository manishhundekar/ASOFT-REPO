package assignment.lms.SpaceRemover;

import java.util.Scanner;

public class TestSpaceRemover {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Input String");
		System.out.println(SpaceRemover.removeSpaces(sc.nextLine()));
		sc.close();
	}
}