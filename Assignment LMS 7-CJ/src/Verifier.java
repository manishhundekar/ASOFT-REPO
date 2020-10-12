import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifier {

	static boolean verifyPassword(String password)
	{
		boolean firstcharaplha = Character.isAlphabetic(password.charAt(0));
		boolean lengthvali = (password.length() >=6)? true : false ;
		//
		//Pattern pattern = Pattern.compile();//[A-Za-z@,#!]*
		//Matcher matcher = pattern.matcher(password);
		//return matcher.find();
		
		return Pattern.matches("[0-9]", password);
	}
	public static void main(String[] args) {
		System.out.println(verifyPassword("Lm1mmmm"));

	}

}
