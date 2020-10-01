
public class Program16 {
	//Fibbo Number
	public static int fib(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		
		//First Ten terms
		System.out.println("First Ten Fibbonachi terms");
		for(int i=0 ; i<10 ;i++)
		{
			System.out.println(fib(i));
		}
		
		//Odd Numbers Less than 100
		System.out.println("Odd Numbers Less than 100 are:");
		for(int i=0 ; i<100 ;i++)
		{
			int f = fib(i);
			if(f%2!=0)
			{
				System.out.println(f);
			}
		}
		
		//Even Numbers between 100 to 1000
		System.out.println("Even Numbers between 100 to 1000 are:");
		for(int i=100 ; i<1000 ;i++)
		{
			int f = fib(i);
			if(f%2==0)
			{
				System.out.println(f);
			}
		}
		
		//Sum
		int sum=0;
		for(int i=0 ; i<100 ;i++)
		{
			sum = sum + fib(i);
		}
		System.out.println("Sum of numbers less than 100 is :" + sum);
	}

}
