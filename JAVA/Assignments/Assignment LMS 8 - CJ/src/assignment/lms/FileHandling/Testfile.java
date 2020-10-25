package assignment.lms.FileHandling;

import java.io.File;
import java.io.IOException;

public class Testfile {

	public static void main(String[] args) throws IOException {
		
		//1
		File dir = new File("D:/Badminton");
		dir.mkdir();
		//2
		File file1 = new File(dir,"singles.txt");
		File file2 = new File(dir,"dubbles.txt");
		file1.createNewFile();
		file2.createNewFile();
		//3
		File subdir = new File(dir,"courts");
		subdir.mkdir();
		//4
		File file3 = new File(subdir,"smash.dat");
		file3.createNewFile();
		//5 Rename
		File file2new = new File(dir,"doubles.txt");
		file2.renameTo(file2new);
		//6 Delete
		file1.delete();
	}

}
