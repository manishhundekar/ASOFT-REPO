import java.util.Scanner;

public class MultiplesAverageClass {

	static float findAverageBy5s(int n)
	{
		float sum=0,count=0;;
		for (int i=5;i<=n;i+=5)
		{
			sum += i;
			count++;
		}
		return sum/count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<0) {System.out.println("Invalid Input"); System.exit(0);}
		if(n>32767) {System.out.println("Number too large"); System.exit(0);}
		System.out.printf("Output: %.2f",findAverageBy5s(n));
		sc.close();
	}

}
