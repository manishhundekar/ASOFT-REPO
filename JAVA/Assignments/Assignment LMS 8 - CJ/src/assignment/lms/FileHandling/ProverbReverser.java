package assignment.lms.FileHandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProverbReverser {

	static void reverseWord(String str)
	{
		String [] temp = new String[10];
		StringBuffer output = new StringBuffer();
		int i = 0;
		for(String word : str.split(" "))
		{
			temp[i++] = word;
		}
		for(int j=9 ; j>=0 ; j--)
		{
			if(temp[j] != null)
				output.append(temp[j] + " ");
		}
		System.out.println(output);
	}
	public static void main(String[] args) throws IOException,NullPointerException {
		File file = new File("TopProverbs.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		String str = new String(bis.readAllBytes());
		for(String line : str.split("\n"))
		{	
			reverseWord(line);
		}
		bis.close();
	}

}
