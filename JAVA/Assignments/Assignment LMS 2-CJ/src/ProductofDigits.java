import java.util.Scanner;
public class ProductofDigits {

	static int productDigits(int num)
	{
		int product=1,digit;
		if(num<0 || num>32767)
		{
			return -1;
		}
		while(num>0)
		{
			digit = num%10;
			product*=digit;
			num = num/10;
		}
		return product;
	}
	
	public static void main(String[] args) {
		// Product of digits
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		int res=productDigits(n);
		if(res == -1)
		{
			System.out.println("Invalid input");
		}
		else
		{
			System.out.println(res);
		}
		sc.close();
	}

}
