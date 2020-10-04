import java.util.Scanner;
public class FindCricketerID {
	
	static int [] cricketer;
	
	static void FindCID(int [] data, int size,int score)
	{
		cricketer = new int[size/2];
		int cricindex=0;
		for (int i=1;i<size;i+=2)
		{
			if(data[i]>score) {cricketer[cricindex++]=data[i-1];}
		}
	}
	
	public static void main(String[] args) {
		// Find Cricketer ID
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
		int score = sc.nextInt();
		if(score<1) {System.out.println("Invalid Score"); System.exit(0);}
		FindCID(data,n,score);
		for(int i : cricketer)
		{
			System.out.println(i);
		}
		sc.close();
	}

}
