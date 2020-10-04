import java.util.Scanner;
public class ElementCount {

	static int findElementCount(int [] input,int size,int element)
	  {
		int count=0;
		  for(int i : input)
		  {
			  if(i == element)
				  count++;
		  }
		  return count;
	  }
	
	public static void main(String[] args) {
		// Element Count
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
		int element = sc.nextInt();
		System.out.println("Elements Repeated:" + findElementCount(data1,n,element));
		sc.close();
	}

}
