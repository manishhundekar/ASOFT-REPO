package assignment.lms.api;

public class WrapperTest {
// INPUT from the command line
	public static void main(String[] args) {
		
		try
		{
			int numbercount = Integer.parseInt(args[0]);
			double [] numbers = new double[numbercount];
			double sum = 0 ;
			for(int i=0 ; i<numbercount ; i++)
			{
				numbers[i] = Double.parseDouble(args[i+1]);
				sum += numbers[i];
			}
			System.out.println(sum);
		}catch(NumberFormatException | ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("DONE");
		
	}

}
