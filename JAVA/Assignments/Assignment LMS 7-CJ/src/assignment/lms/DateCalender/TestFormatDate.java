package assignment.lms.DateCalender;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFormatDate {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println(df.format(date));
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		System.out.println(df1.format(date));
		//System.out.println(df.parse("26/06/1997"));
	}

}
