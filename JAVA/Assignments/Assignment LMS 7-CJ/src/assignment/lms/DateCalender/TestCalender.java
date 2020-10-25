package assignment.lms.DateCalender;

import java.util.Calendar;
import java.util.Date;

public class TestCalender {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("Today's Date "  + cal.get(cal.DATE));
		System.out.println("This Year "  + cal.get(cal.YEAR));
		System.out.println("This Hour "  + cal.get(cal.HOUR));
		cal.add(cal.HOUR, 2);
		System.out.println("2 hours added to the present time");
		System.out.println("Updated Hour "  + cal.get(cal.HOUR));
		cal.add(cal.MINUTE, -5);
		System.out.println("5 Minutes substracted from the present time");
		System.out.println("Updated Minutes "  + cal.get(cal.MINUTE));
		Date date = cal.getTime();
		System.out.println(date);
	}

}
