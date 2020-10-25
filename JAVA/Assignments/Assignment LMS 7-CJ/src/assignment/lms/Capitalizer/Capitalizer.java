package assignment.lms.Capitalizer;

public class Capitalizer {

	static String capitalize(String input)
	{
		String [] words = input.split(" ");
		StringBuffer sb = new StringBuffer("");
		for(String word : words)
		{
			sb.append(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ");
		}
		return sb.toString();	
	}

}
