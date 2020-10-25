package assignment.lms.FormatChanger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatChanger {

	static String changeFormat(String input) throws ParseException
	{
		 Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
		 String newdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return newdate;
		
	}
	public static void main(String[] args) throws ParseException {
		
		System.out.println(changeFormat("26/06/1998"));
	}

}
