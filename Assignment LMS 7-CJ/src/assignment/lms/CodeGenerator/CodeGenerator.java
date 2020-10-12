package assignment.lms.CodeGenerator;

public class CodeGenerator {
	static StringBuilder generateCode(String input)
	{
		StringBuilder sb = new StringBuilder(input);
		return new StringBuilder(sb.reverse().replace(0, 1,"").replace(0,2,"*").replace(sb.length()-1,sb.length(),"#").toString().toUpperCase());	
	}
}
