import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader(new File("demo.txt"));
		FileWriter writer = new FileWriter(new File("demo1.txt"));
		int i ;
		while((i = reader.read()) != -1)
		{
			writer.write(i);
			System.out.print((char)i);
		}
		writer.close();
	}

}
