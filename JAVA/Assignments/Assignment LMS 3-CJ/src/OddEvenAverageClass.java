import java.util.Scanner;

public class OddEvenAverageClass {

	static float avgOddEvenSum(int [] input,int size)
	{
		float evensum=0,oddsum=0;
		for (int i : input)
		{
			if(i%2==0)
			{
				evensum += i;
			}
			else
			{
				oddsum += i;
			}
		}
		return (evensum+oddsum)/2;
	}
	
	public static void main(String[] args) {
		// OddEvenAverageClass
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<1) {System.out.println("Invalid Array Size"); System.exit(0);}
		int [] data1 = new int[n];
		for(int i=0; i<n ; i++)
		{
			data1[i] = sc.nextInt();
			if(data1[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		System.out.printf("Output: %.2f" , avgOddEvenSum(data1,n));
		sc.close();
	}

}
