import java.util.Scanner;
public class VehicleNumber {

	public static int sumofdigits(int n)
	{
		int sum=0,digit;
		while(n>0)
		{
			digit = n%10;
			sum += digit;
			n = n/10;
		}
		return sum;
		
	}
	public static void main(String[] args) {
		// Vehicle Number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Start Range:");
		int start = sc.nextInt();
		System.out.println("Enter End Range:");
		int end = sc.nextInt();
		System.out.println("Available Series are:");
		for(int i=start; i<=end ; i++)
		{
			if(sumofdigits(i)==9)
			{
				System.out.println(i);
			}
		}
		sc.close();
	}

}
