import java.util.Scanner;
public class RepeatedSalaryCount {

	static int countRepeaters(int [] input,int size)
	{
		int count=0;
		for(int i=0; i<size ; i++)
		{
			for(int j= i+1 ; j<size ; j++)
			{
				if(input[i]==input[j])
				{
					count+=2;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// RepeatedSalaryCount
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<1) {System.out.println("Invalid Input"); System.exit(0);}
		int [] data = new int[n];
		for(int i=0; i<n ; i++)
		{
			data[i] = sc.nextInt();
			if(data[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		System.out.println("Output:" + countRepeaters(data,n));
		sc.close();
	}

}

