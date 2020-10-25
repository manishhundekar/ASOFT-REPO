package assignment.lms.FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProverbCollection {

	static void storeProverb(String proverb) throws IOException
	{
		File file = new File("TopProverbs.txt");
		FileWriter writer = new FileWriter(file, true);
		writer.append(proverb + "\n");
		System.out.println("Proverb added");
		writer.close();
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String input;
		while(true)
		{
		  System.out.println("Enter the Proverb");
		  input = sc.nextLine();
		  if(input.equals("STOP")) {break;}
		  storeProverb(input);
		}
		System.out.println("Terminated");
		sc.close();
	}

}
