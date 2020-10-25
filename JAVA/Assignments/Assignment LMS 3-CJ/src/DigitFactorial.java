import java.util.Scanner;
public class DigitFactorial {
	
	static int [] factorial ;
	
	static int factorial(int n)
	{
		if(n==1)
		{
			return 1;
		}
		return n * factorial(n-1);
		
	}
	
	static void digitFactorial(int n)
	{
		int [] temp = new int[20];
		int index =0;
		while(n>0)
		{
			int digit = n%10;
			temp[index++] = factorial(digit);
			n /= 10;
		}
		//
		factorial = new int[index];
		for(int i=0 ; i<index ; i++)
		{
			factorial[i]=temp[i];
		}
	}
	
	public static void main(String[] args) {
		// Digit Factorial
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<0) {System.out.println("Number too small"); System.exit(0);}
		if(n>32767) {System.out.println("Number too large"); System.exit(0);}
		digitFactorial(n);
		for(int i : factorial)
		{
			System.out.println(i);
		}
		sc.close();
	}

}
