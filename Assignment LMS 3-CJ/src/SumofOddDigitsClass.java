import java.util.Scanner;

public class SumofOddDigitsClass {

	static int sumOddDigits(int n)
	{
		if(n<0 || n>32767)
		{
			return -1;
		}
		int sum=0;
		while(n>0)
		{
			int digit = n%10;
			if(digit%2!=0)
			{
				sum += digit;
			}
			n /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		int res = sumOddDigits(n);
		if(res == -1)
		{
			System.out.println("Invalid Input");
		}
		else
		{
			System.out.println("Output:" + res);
		}
		sc.close();
	}

}