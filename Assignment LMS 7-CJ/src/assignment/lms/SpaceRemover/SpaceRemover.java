package assignment.lms.SpaceRemover;

public class SpaceRemover {

	static String removeSpaces(String input)
	{
		return input.trim().replaceAll(" +", " ");
	}
}
