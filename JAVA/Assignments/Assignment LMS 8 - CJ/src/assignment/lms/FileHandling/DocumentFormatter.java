package assignment.lms.FileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DocumentFormatter {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File file = new File("TopProverbs.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		String str = new String(bis.readAllBytes());
		System.out.println("Enter the new File name : ");
		String filename = sc.nextLine();
		File file2 = new File(filename);
		file2.createNewFile();
		StringBuffer output = new StringBuffer();
		for(String line : str.split("\n"))
		{	
			output.append(line.trim().replaceAll(" +", " ") + "\n");
		}
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
		String strout = new String(output);
		bos.write(strout.getBytes());
		System.out.println(output);
		bos.close();
		bis.close();
		sc.close();
	}

}
