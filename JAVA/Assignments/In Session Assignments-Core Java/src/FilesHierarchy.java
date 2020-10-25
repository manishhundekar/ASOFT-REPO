import java.io.File;

public class FilesHierarchy {
	static int level=0;
	static void showList(File file)
	{
		File [] files = file.listFiles();
		for(File f : files)
		{
			for(int i=0 ; i<level ; i++)
			{
				System.out.print(" \t\t ");
			}
			System.out.println(f.getName());
			if(f.isDirectory())
			{
				level++;
				showList(f);
			}
		}
		level--;
	}
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\pc\\eclipse-workspace\\08102020");
		showList(file);
	}

}