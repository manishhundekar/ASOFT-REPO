package assignment.lms.FileHandling;

import java.io.File;

public class FolderInfo {

	static void printDirectory(String path){
		File file = new File(path);
		File [] filelist = file.listFiles();
		for(File s : filelist)
		{
			if(s.isFile())
			{
				System.out.println("File : " + s.getName() + "\nAbsolute File Path : " + s.getAbsoluteFile() + "\nFolder Path : " + s.getParent());
			}
			else
			{
				System.out.println("Directory : " + s.getName() + "\nPath : " + s.getAbsoluteFile());
			}
		}
	}
	public static void main(String[] args) {
		try{
			printDirectory("D://");
		}catch(NullPointerException e)
		{
			//e.printStackTrace();
			System.out.println("No Folder exists with the given name");
		}

	}

}
