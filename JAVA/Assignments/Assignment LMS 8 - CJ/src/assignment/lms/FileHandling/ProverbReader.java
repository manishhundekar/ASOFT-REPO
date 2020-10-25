package assignment.lms.FileHandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProverbReader {

	public static void main(String[] args) throws IOException {
		File file = new File("TopProverbs.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int i;
		while((i = bis.read())!= -1)
		{
			System.out.println(i);
		}
		bis.close();
	}

}
