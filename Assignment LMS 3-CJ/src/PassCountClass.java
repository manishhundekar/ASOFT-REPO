import java.util.Scanner;
public class PassCountClass {

	static int passCount(int [] input,int size)
	  {
		int count=0;
		  for(int i : input)
		  {
			  if(i >= 70)
				  count++;
		  }
		  return count;
	  }
	
	public static void main(String[] args) {
		// Pass Count
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n%2!=0) {System.out.println("Invalid Size"); System.exit(0);}
		int [] data1 = new int[n];
		for(int i=0; i<n ; i++)
		{
			data1[i] = sc.nextInt();
			if(data1[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		System.out.println("Pass Count:" + passCount(data1,n));
		sc.close();
	}

}