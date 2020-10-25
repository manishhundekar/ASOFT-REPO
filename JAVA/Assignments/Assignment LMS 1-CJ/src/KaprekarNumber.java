import java.util.Scanner;
public class KaprekarNumber {

	public static int noofdigits(int n)
	{
		int digit=0;
		while(n>0)
		{
			digit++;
			n = n/10;
		}
		return digit;
		
	}
	
	public static void main(String[] args) {
		// Kaprekar Number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = sc.nextInt();
		
		int numsquare = (int) Math.pow(num, 2);
		int n = noofdigits(numsquare);
		
		int dividenum = (int) Math.pow(10, Math.ceil(n/2));
		double sum = numsquare/dividenum + numsquare%dividenum;
		System.out.println(sum);
		if(sum == num)
		{
			System.out.println("It is a Kaprekar Number") ;
		}
		else
		{
			 System.out.println("It is not a Kaprekar Number") ;
		}
		sc.close();
	}

}
