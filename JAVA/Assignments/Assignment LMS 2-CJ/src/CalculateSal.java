import java.util.Scanner;
public class CalculateSal {

	public static int calculateSal(int salary,int shifts)
	{
		return (int)( salary - (salary*0.5) + (0.02*salary*shifts));
	}
	public static void main(String[] args) {
		// CalculateSal
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Salary:");
		int salary = sc.nextInt();
		System.out.println("No of Shifts:");
		int shifts = sc.nextInt();
		if(salary > 8000)
			System.out.println("Salary too large");
		else if(salary < 0)
			System.out.println("Salary too small");
		else if(shifts < 0)
			System.out.println("Shifts too small");
		else
		{
			System.out.println(calculateSal(salary,shifts));
		}
		sc.close();
	}

}
