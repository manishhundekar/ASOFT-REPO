import java.util.Scanner;
public class PrimeIndexSumClass {

	static boolean isPrime(int n)
	{
	    if (n%2==0) return false; 
	    for(int i=3;i<=Math.sqrt(n);i+=2) { 
	        if(n%i==0) 
	            return false; 
	    } 
	    return true; 
	}
	static int primeIndexSum(int [] arr,int size)
	{
		int sum=0,count=0;
		for(int i=0; i<size ; i++)
		{
			if(isPrime(i+1))
			{
				sum += arr[i];
				count++;
			}
		}
		return sum/count;
	}
	
	public static void main(String[] args) {
		// PrimeIndexSum
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
		System.out.println("Prime Index Average:" + primeIndexSum(data1,n));
		sc.close();
	}

}
