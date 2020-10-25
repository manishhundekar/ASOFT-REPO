import java.util.Scanner;
public class maximumSum {

	static int summaxoddeven(int [] input,int size)
	{
		int evensum=0,oddsum=0;
		for(int i=0; i<size ; i++)
		{
			if(input[i]%2==0)
				evensum+=input[i];
			else
				oddsum+=input[i];
		}
		if(evensum>oddsum) {return evensum;} else {return oddsum;}
	}
	
	public static void main(String[] args) {
		// Maximum odd and Maximum Even
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<1) {System.out.println("Invalid array size"); System.exit(0);}
		int [] data = new int[n];
		for(int i=0; i<n ; i++)
		{
			data[i] = sc.nextInt();
			if(data[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		System.out.println("Output:" + summaxoddeven(data,n));
		sc.close();
	}

}
