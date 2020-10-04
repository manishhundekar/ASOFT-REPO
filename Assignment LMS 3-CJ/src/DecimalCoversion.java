import java.util.Scanner;
public class DecimalCoversion {

	static boolean isBinary(int n)
	{
		int temp = n;
		while(temp>0)
		{
			int digit = temp%10;
			if(digit>1)
			{
				return false;
			}
			temp /= 10;
		}
		return true;
		
	}
	
	static int convertToDecimal(int n)
	{
		int output=0,digit;
		if(n<1 || !isBinary(n)) 
		{
			return -1;
		}
		int place =0;
		while(n>0)
		{
			digit = n%10 ;
			output += digit * Math.pow(2,place++);
			n /= 10 ;
		}
		return output;
	}
	
	public static void main(String[] args) {
		// Binary to Decimal Conversion
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		int res = convertToDecimal(n);
		if(res == -1)
		{
			System.out.println("Invalid Input");
		}
		else
		{
			System.out.println("Output: " +res);
		}
		sc.close();
	}

}
