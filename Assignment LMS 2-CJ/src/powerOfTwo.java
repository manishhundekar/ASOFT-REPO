import java.util.Scanner;
public class powerOfTwo {

	static int poweroftwofunc(int n)
	{
		if (n == 0)
            return 0;
         
        while (n != 1)
        {
            if (n % 2 != 0)
                return 0;
            n = n / 2;
        }
        return 1;
	}
	public static void main(String[] args) {
		// Power of two
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<0) {System.out.println("Number too small"); System.exit(0);}
		if(n>32767) {System.out.println("Number too large"); System.exit(0);}
		if(poweroftwofunc(n)==1)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		sc.close();
	}
}